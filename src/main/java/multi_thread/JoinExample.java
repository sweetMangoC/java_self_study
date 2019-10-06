package multi_thread;

public class JoinExample {

    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
        }

        System.out.println(sumThread.getSum());
    }

    private static class SumThread extends Thread {
        private long sum;

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }

        public void run() {
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
        }
    }
}
