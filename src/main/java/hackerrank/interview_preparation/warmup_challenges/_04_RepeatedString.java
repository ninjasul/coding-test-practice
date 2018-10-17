package hackerrank.interview_preparation.warmup_challenges;


/*
https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
*/

import java.util.Scanner;

public class _04_RepeatedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long n = sc.nextLong();

        System.out.println(repeatedString(s, n));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long length = s.length();
        long remainderLength = n%length;

        long aFullCount = 0;
        long aRemainderCount = 0;

        for( int i = 0; i < length; ++i ) {
            if( s.charAt(i) == 'a' ) {
                aFullCount++;

                if( i < remainderLength ) {
                    aRemainderCount++;
                }
            }
        }

        return (aFullCount*(n/length)) + aRemainderCount;
    }
}
