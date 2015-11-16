import java.nio.file.AtomicMoveNotSupportedException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gvrousto on 11/15/15.
 */
public class SumSquareDifference {
    private int num;
    public static AtomicInteger difference = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new sumSquared(100));
        Thread t2 = new Thread(new squareSum(100));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sumSquared.sSquared.get() - squareSum.squareSum.get());
    }

}

class sumSquared implements Runnable {
    public static AtomicInteger sSquared = new AtomicInteger();
    private int num;

    public sumSquared(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < num; i++) {
                sSquared.getAndAdd(i);
            }
            sSquared.getAndAdd(sSquared.get() * sSquared.get());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

class squareSum implements Runnable {
    public static AtomicInteger squareSum = new AtomicInteger();
    private int num;

    public squareSum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < num; i++) {
                int temp = i * i;
                squareSum.getAndAdd(temp);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}