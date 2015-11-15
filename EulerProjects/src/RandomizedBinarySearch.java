import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by gvrousto on 10/26/15.
 */
public class RandomizedBinarySearch {
    /*
    A secret integer t is selected at random within the range 1 ? t ? n.

The goal is to guess the value of t by making repeated guesses, via integer g. After a guess is made, there are three possible outcomes, in which it will be revealed that either g < t, g = t, or g > t. Then the process can repeat as necessary.

Normally, the number of guesses required on average can be minimized with a binary search: Given a lower bound L and upper bound H (initialized to L = 1 and H = n), let g = ?(L+H)/2? where ??? is the integer floor function. If g = t, the process ends.
Otherwise, if g < t, set L = g+1, but if g > t instead, set H = g?1. After setting the new bounds, the search process repeats, and ultimately ends once t is found. Even if t can be deduced without searching, assume that a search will be required anyway to confirm the value.

Your friend Bob believes that the standard binary search is not that much better than his randomized variant: Instead of setting g = ?(L+H)/2?, simply let g be a random integer between L and H, inclusive. The rest of the algorithm is the same as the standard binary search. This new search routine will be referred to as a random binary search.

Given that 1 ? t ? n for random t, let B(n) be the expected number of guesses needed to find t using the standard binary search, and let R(n) be the expected number of guesses needed to find t using the random binary search. For example, B(6) = 2.33333333 and R(6) = 2.71666667 when rounded to 8 decimal places.

Find R(1010) ? B(1010) rounded to 8 decimal places.
     */
    private int upperBound;
    private int lowerBound;
    private int secret;

    public RandomizedBinarySearch(int upperBound) {
        this.secret = (int) (upperBound * Math.random());
        this.upperBound = upperBound;
        this.lowerBound = 1;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getSecret() {
        return secret;
    }

    public int binarySearch() {
        int numGuesses = 1;
        int H = getUpperBound();
        int L = getLowerBound();
        int g = ((H + L) / 2);
        while (g != getSecret()) {
            if (g < getSecret()) {
                L += 1;
            }
            if (g > getSecret()) {
                H -= 1;
            }
            g = ((H + L) / 2);
            numGuesses++;
        }
        return numGuesses;
    }

    public int randomBinarySearch() {
        int numGuesses = 1;
        int H = getUpperBound();
        int L = getLowerBound();
        int g = (int) (H * Math.random());
        while (g != numGuesses) {
            if (g < getSecret()) {
                L += 1;
            }
            if (g > getSecret()) {
                L -= 1;
            }
            g = (int) (H * Math.random());
            numGuesses++;
        }
        return numGuesses;
    }

    public static void main(String[] args) {
        //they didnt specify how many times to average out the number of guesses so i pick 5
        // becuase its a cool number.
        int n = (int) Math.pow(10, 10);
        RandomizedBinarySearch Alexa = new RandomizedBinarySearch(n);
        //rounds it to 8 decimal places
        DecimalFormat df = new DecimalFormat("#.########");
        int b = 0;
        for (int i = 0; i < 5; i++) {
            b += Alexa.binarySearch();
        }
        double B = b / 5;
        int r = 0;
        for(int i =0; i < 5; i++){
            r += Alexa.randomBinarySearch();
        }
        double R = r/5;
        System.out.println(df.format(B) + "-" + df.format(R));
    }
}
