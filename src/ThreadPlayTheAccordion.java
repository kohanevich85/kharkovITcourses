
public class ThreadPlayTheAccordion {

    public static void main(String[] args) throws InterruptedException {

        Runnable manager0 = new ManagerRunnable();
        Thread manager1 = new Thread(manager0);
        manager1.start();
        manager1.join();
    }
}

class ManagerRunnable implements Runnable {

    @Override
    public void run() {

        for (int k = 0; k < 10; k++) {
            //A+B
            Runnable printerA = new PrintRunnable("A .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();

            Runnable printerB = new PrintRunnable(". B", 98);
            Thread threadB = new Thread(printerB);
            threadB.start();

            try {
                threadA.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            try {
                threadB.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            //C
            System.out.println("-----");
            Runnable printerC = new PrintRunnable(" C", 100);
            Thread threadC = new Thread(printerC);
            threadC.start();

            try {
                threadC.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("-----");
        }
    }
}

class PrintRunnable implements Runnable {

    private String msg;
    private long timeSlipMs;

    public PrintRunnable(String msg, long timeSlipMs) {

        this.msg = msg;
        this.timeSlipMs = timeSlipMs;
    }

    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
                Thread.sleep(timeSlipMs);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(msg);
        }
    }
}
