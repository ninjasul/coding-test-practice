package hackerank.interview_preparation;

import java.util.Scanner;

public class _02_CountingValleys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(String.valueOf(countingValleys(n, s)));

    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int curLevel = 0;
        int countOfValleys = 0;

        for( int i = 0; i < n; ++i ) {
            char c = s.charAt(i);

            if( c == 'U' ) {
                curLevel++;

                if( curLevel == 0 && i != 0 ) {
                    countOfValleys++;
                }
            }
            else if( c == 'D' ) {
                curLevel--;
            }
        }

        return countOfValleys;
    }
}
