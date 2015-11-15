/**
 * Created by gvrousto on 10/30/15.
 */
/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

The number that is divisible by all numbers from 1 to 20 would countain all the prime factors of
every number from 1 to 20. Only works for 1-20 or less
 */
public class SmallestMultiple {
    int from;
    int to;
    long res;
    int[] primes = {2,3,5,7,11,13,17,19};

    public SmallestMultiple(int from, int to) {
        this.from = from;
        this.to = to;
        res = 1L;
    }
    public long findSmallestMultiple(){
        for(int i = from; i <= to; i++){
            int temp = i;
            while(temp != 1) {
                for (int j = 0; j < primes.length; j++) {
                    System.out.println(temp);
                    if (temp % primes[j] == 0) {
                        temp = temp / primes[j];
                        res = res * primes[j];
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        SmallestMultiple Alexa = new SmallestMultiple(1,20);
        System.out.println(Alexa.findSmallestMultiple());
    }
}