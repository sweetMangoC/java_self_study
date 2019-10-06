package multi_thread;

public class Interrupt01 {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.setName("wonpyo's Interrupted Test Thread");
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        thread.interrupt();
    }

    public static class PrintThread2 extends Thread {
        public void run() {

            while (true) {
                System.out.println("running " + getName());

                if (Thread.interrupted()) {
                    break;
                }
            }
            System.out.println("clean resource");
            System.out.println("running end");
        }
    }
}
