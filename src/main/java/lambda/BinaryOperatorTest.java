package lambda;

import lombok.Getter;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.minBy(Comparator.comparingInt(Fruit::getCost));

        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("사과",  3000));

        System.out.println(fruit.getName());

        binaryOperator = BinaryOperator.maxBy(Comparator.comparingInt(Fruit::getCost));

        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("사과",  3000));

        System.out.println(fruit.getName());
    }

    public static class Fruit {
        @Getter
        private String name;
        @Getter
        private Integer cost;

        public Fruit(String name, Integer cost) {
            this.name = name;
            this.cost = cost;
        }
    }
}
