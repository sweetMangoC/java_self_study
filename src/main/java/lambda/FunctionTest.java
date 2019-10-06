package lambda;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;

        String city;

        functionA = (m) -> m.getAddress();
        functionB = (a) -> a.getCity();

        functionAB = functionA.andThen(functionB);

        city = functionAB.apply(new Member("최원표", 27, new Address("대한민국", "성남")));

        System.out.println("come on" + city);

        functionAB = functionB.compose(functionA);

        city = functionAB.apply(new Member("최원표", 27, new Address("대한민국", "성남")));

        System.out.println("come on" + city);
    }
}
