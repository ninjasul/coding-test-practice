package hackerrank.interview_preparation.warmup_challenges;

import java.util.Scanner;

public class _03_JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");

        int [] c = new int[n];
        for( int i = 0; i < n; ++i ) {
            c[i] = Integer.parseInt(s[i]);
        }

        System.out.println(jumpingOnClouds(c));
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int minCount = 0;

        int length = c.length;
        for( int i = 0; i < length-1; ) {
            if( i < length-2 && c[i+2] == 0 ) {
                i += 2;
            }
            else {
                i++;
            }

            minCount++;
        }

        return minCount;

    }
}
