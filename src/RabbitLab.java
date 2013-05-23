
public class RabbitLab {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new RabbitPrinter()).start();
    }
}

class RabbitPrinter implements Runnable {

    @Override
    public void run() {
        System.out.println("New rabbit born!");

        for (int i = 1; i < 1000000000; i++) {
            try {
                new Thread(new RabbitPrinter()).start();
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
