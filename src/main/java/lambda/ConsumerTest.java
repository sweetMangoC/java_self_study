package lambda;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<Member> consumerA = (m) -> System.out.println(m.getName());

        Consumer<Member> consumerB = (m) -> System.out.println(m.getAge());

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("최원표", 27));
    }

}