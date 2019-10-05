package multi_thread;

public class WaitNotifyExample {

    public static void main(String[] args) {

        WorkObject workObject = new WorkObject();
        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }

    private static class WorkObject {
        public synchronized void methodA(int i) {
            System.out.println("ThreadA metohdA" + i);
            notify();
            try {
                wait();
            }catch (InterruptedException e) {}
        }

        public synchronized void methodB(int i) {
            System.out.println("ThreadB metohdB" + i);
            notify();
            try {
                wait();
            }catch (InterruptedException e) {}
        }
    }

    private static class ThreadA extends Thread {
        private WorkObject workObject;
        public ThreadA(WorkObject workObject) {
            this.workObject = workObject;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                workObject.methodA(i);
            }
        }
    }

    private static class ThreadB extends Thread {
        private WorkObject workObject;
        public ThreadB(WorkObject workObject) {
            this.workObject = workObject;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                workObject.methodB(i);
            }
        }
    }
}
