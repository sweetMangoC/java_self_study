package multi_thread;

import java.nio.channels.Pipe;

public class ProducerCosumnerExample {

    public static void main(String[] args) {
        DataBox dataBox = new DataBox();
        Producer producer = new Producer(dataBox);
        Consumer consumer = new Consumer(dataBox);

        producer.start();
        consumer.start();

    }

    private static class DataBox {
        private String data;

        public synchronized void setData(String data) {
            if (this.data != null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("generated: " + data);
            this.data = data;
            notify();
        }

        public synchronized void getData() {
            if(this.data == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            String value = this.data;
            System.out.println(value);
            this.data = null;
            notify();
        }
    }

    private static class Consumer extends Thread{
        private DataBox dataBox;

        public Consumer(DataBox dataBox) {
            this.dataBox = dataBox;
        }

        public void run() {
            for(int i = 0; i < 10; i++) {
                dataBox.getData();
            }
        }
    }

    private static class Producer extends Thread{
        private DataBox dataBox;

        public Producer(DataBox dataBox) {
            this.dataBox = dataBox;
        }

        public void run() {
            for(int i = 0; i < 10; i++) {
                dataBox.setData("helloWorld setData " + i);
            }
        }
    }
}
