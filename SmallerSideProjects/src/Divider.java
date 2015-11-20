import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gvrousto on 10/29/15.
 */
public class Divider extends Thread {
    private static AtomicInteger alexa = new AtomicInteger();
    private int start;
    private int end;
    private String error = "Big problem";

    public Divider(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int getCounter() {
        return alexa.get();
    }

    public static void setCounter() {
        alexa.set(0);
    }

    public void increment() {
        alexa.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 7 == 0) {
                increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread d0 = new Divider(0, 1000);
        Thread d1 = new Divider(1001, 2000);
        Thread d2 = new Divider(2001, 3000);
        d0.start();
        d1.start();
        d2.start();
        try {
            d0.join();
            d1.join();
            d2.join();
        } catch (Exception e) {
            System.out.println("Big Problem");
        }
        System.out.println(alexa.get());
    }
}
