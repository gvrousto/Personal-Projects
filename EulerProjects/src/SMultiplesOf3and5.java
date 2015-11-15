import java.util.concurrent.atomic.AtomicInteger;
import java.lang.*;
/**
 * Created by gvrousto on 10/28/15.
 */
public class SMultiplesOf3and5 implements Runnable {
    /*
    Create the MultiplesOf3And5 project but now implementing the concurrency ideas I learned in
    class.
     */
    private static AtomicInteger Alexa = new AtomicInteger();
    private int num;
    private int multiple;
    private String error = "Big problem";

    public SMultiplesOf3and5(int num, int multiple){
        this.num = num;
        this.multiple = multiple;
    }

    public void increment(int num){
        Alexa.getAndAdd(num);
    }

    @Override
    public void run(){
            for (int i = 0; i < num; i++) {
                if (i % multiple == 0) {
                    increment(i);
                }
            }
    }

    public static void main(String[] args){
        Thread mult3 = new Thread(new SMultiplesOf3and5(100,3));
        Thread mult5 = new Thread(new SMultiplesOf3and5(100,5));
        mult3.start();
        mult5.start();
        try{
            mult3.join();
            mult5.join();
            } catch(InterruptedException e) {
                 System.out.println("Big error");
        }
        System.out.println(Alexa.get());
    }
}
