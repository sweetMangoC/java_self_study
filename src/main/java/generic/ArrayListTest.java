package generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        printNumberList(list);
    }

    public static <T extends Number> void printNumberList(List<T> numberList) {
        for (T number : numberList) {
            System.out.println(number);
        }
    }

    public static void hello(List<? extends Number> data) {
        data.get(0).doubleValue();
    }
}
