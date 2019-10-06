package generic;

public class LambdaTest {
    public static void main(String[] args) {
        SumInterface<Integer> sumInterface = (a, b) -> a + b;

        System.out.println(sumInterface.sum(3, 4));
    }
}

@FunctionalInterface
interface SumInterface<T extends Number> {
    T sum(T a, T b);
}
