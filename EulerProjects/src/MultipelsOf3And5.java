/**
 * Created by gvrousto on 10/25/15.
 */
public class MultipelsOf3And5 {
    /*
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public int multiplesOf3And5(int num){
        return multiples3(num) + multiples5(num);
    }
    public int multiples3(int num){
        int res = 0;
        for(int i = 0; i < num; i++) {
            if(i % 3 == 0){
                res+=i;
            }
        }
        return res;
    }
    public int multiples5(int num){
        int res = 0;
        for(int i = 0; i < num; i++) {
            if(i % 5 == 0){
                res+=i;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int x = 100;
        MultipelsOf3And5 Alexa = new MultipelsOf3And5();
        System.out.println(Alexa.multiplesOf3And5(x));
    }
}
