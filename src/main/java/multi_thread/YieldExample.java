package multi_thread;

public class YieldExample {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        threadA.work = false;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        threadA.work = true;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        threadA.stop = true;
        threadB.stop = true;
    }

    private static class ThreadA extends Thread {
        public boolean stop = false;
        public boolean work = true;

        public void run() {
            while (!stop) {
                if (work) {
                    System.out.println("ThreadA is running");
                } else {
                    Thread.yield();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private static class ThreadB extends Thread {
        public boolean stop = false;
        public boolean work = true;

        public void run() {
            while (!stop) {
                if (work) {
                    System.out.println("ThreadB is running");
                } else {
                    Thread.yield();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
