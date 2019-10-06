package generic;

public class GenericMethodTest {
    public static void main(String[] args) {
        GenericMethodTest genericMethodTest = new GenericMethodTest();
        Box a = genericMethodTest.getBox(3);
        System.out.println(a.getValue());
        Box b = genericMethodTest.<Integer>getBox(4);
        System.out.println(b.getValue());
    }

    public <T> Box<T> getBox(int a) {
        Box<T> box = new Box<>();
        System.out.println(a);
        return box;
    }

    class Box<T> {
        private T value;

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
