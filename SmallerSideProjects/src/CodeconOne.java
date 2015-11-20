/**
 * Outputs the time it takes to transmit information about a company's financial success
 * Created by Gus Vroustouris gvrvousto@purdue.edu
 */
import java.util.Scanner;
public class CodeconOne {
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt(); //number of people
        int K = stdin.nextInt(); //number of simultaneous transmission you can make
        int T = stdin.nextInt(); //time it takes for a transmission
        int people = 1; // 1 person has the information (you)
        int duration = 0; // time starts at 0 when you get the information
        while(stdin.hasNextLine())
        {
            System.out.println(stdin.nextLine());
            for (duration = 0; people < N;duration+=T) // while the people who have it is less than the people
                                                       // you want to give it to continue the loop and add the time it
                                                       // took to transmit the information on to time
            {
                if (K<(N-people)) { //as long as the number of people you can simultaneously send it to is less
                                    // than people you want minus the people that have it execute the loop
                    if (K == 1) { //special case: if K = 1 so it increments by one
                        people = people + K;
                    }
                    else { // if it isnt one then the correct case to run is the number of eople times K
                        people = people * K;
                    }
                }
                else{
                    people = N;
                }
            }
        }

        System.out.println(duration);
        stdin.close();
    }
}
