import java.lang.reflect.Array;

/**
 * Created by gvrousto on 10/28/15.
 */
/*
    I could not get this project to work reliably. It takes much too long to run. I need to
    implement a sieve (Quadratic, Atkin, Eratosthenes) to compute the primes fo such a large number.
    I could not find the greatest common factor of 600851475143.
 */
public class LargestPrimeFactor {
    public long largestPrimeFactor(long factor) {
        int prime;
        for (prime = 2; prime <= factor; prime++) {
            if (factor % prime == 0) {
                factor /= prime;
                prime--;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        LargestPrimeFactor Alexa = new LargestPrimeFactor();
        System.out.println(Alexa.largestPrimeFactor(600851475143L));
    }

}
