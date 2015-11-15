import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gvrousto on 11/14/15.
 */
public class LargestPalindromeProduct implements Runnable {
    private static AtomicInteger largestPalindrome = new AtomicInteger();
    String error = "There was an error";
    private int start;
    private int stop;

    public LargestPalindromeProduct(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public boolean isPalindrome(int num) {
        String numAsString = num + "";
        char[] arr = numAsString.toCharArray();
        char[] temp = new char[arr.length];
        int counter = 0;
        for (int i = arr.length; i > 0; i--) {
            temp[counter] = arr[i];
            counter++;
        }
        String straw = temp.toString();
        if (numAsString.equals(straw)) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        try {
            for (int i = 100; i < 999; i++) {
                for (int j = start; j < stop; j++) {
                    if (isPalindrome(j * i) && j * i > largestPalindrome.get()) {
                        largestPalindrome.set(j * i);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(error);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new LargestPalindromeProduct(100, 400));
        Thread t2 = new Thread(new LargestPalindromeProduct(400, 700));
        Thread t3 = new Thread(new LargestPalindromeProduct(700, 999));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(largestPalindrome.get());
    }

}
