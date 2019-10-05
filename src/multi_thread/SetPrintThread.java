package multi_thread;

public class SetPrintThread {

    public static void main(String[] args) {
        TargetThread targetThread = new TargetThread();
        TargetThreadStatePrinter printer = new TargetThreadStatePrinter(targetThread);

        printer.start();
    }


    public static class TargetThreadStatePrinter extends Thread{
        private Thread targetThread;
        TargetThreadStatePrinter(Thread targetThread) {
            this.targetThread = targetThread;
        }

        public void run() {
            while(true) {
                System.out.println(targetThread.getState().name());

                if(targetThread.getState().equals(Thread.State.NEW)) {
                    targetThread.start();
                }

                if(targetThread.getState().equals(Thread.State.TERMINATED)) {
                    break;
                }

                try {
                    Thread.sleep(500);
                }catch (InterruptedException e) {}
            }
        }

    }
    public static class TargetThread extends Thread{
        public void run() {
            for(int i = 0; i <1000000000; i++ ){

            }

            try {
                Thread.sleep(1500);
            }catch (InterruptedException e) {

            }

            for(int i = 0; i <1000000000; i++ ){

            }
        }
    }
}
