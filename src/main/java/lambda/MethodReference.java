package lambda;

import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

// 정적 메소도아 인스턴스 메소드 참조. 클래스 :: 메소드 나, 참조변수 :: 메소드
// 매개변수의 메소드 참조 => (a, b) -> a.compareToIgnoreCase(b) 와 같이, 함수의 매개변수의 메서드를 사용하는 경우
public class MethodReference {
    public static void main(String[] args) {
        String hello = "Hello";
        String hello2 = "Hello2";


        ToIntBiFunction<String,String> function= String::compareToIgnoreCase; // 매개변수의 메소드 참조.

        IntBinaryOperator operator = Calculator::sum; //정적 메소드 참조.
        // 매개변수의 메소드 참조와, 정적 메소드 참조는 거의 같아보인다....
        // 하지만 작동 방식은 전혀 다르게 된다는 걸....

        Calculator instance = new Calculator();
        IntBinaryOperator operator2 = instance :: instanceSum; //인스턴스 메소드 참조.


        //생성자 참조는 클래스 :: new 이다.

    }
    public static class Calculator {
        public static int sum(int a, int b) {
            return a + b;
        }

        public int instanceSum(int a, int b) {
            return a + b;
        }
    }
}
