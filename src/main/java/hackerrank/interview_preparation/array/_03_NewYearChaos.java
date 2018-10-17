package hackerrank.interview_preparation.array;

import java.util.Scanner;

public class _03_NewYearChaos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for( int i = 0; i < t; ++i ) {
            int n = sc.nextInt();
            sc.nextLine();
            int [] q = new int[n];
            String[] nums = sc.nextLine().split(" ");

            for( int j = 0; j < n; ++j ) {
                q[j] = Integer.parseInt(nums[j]);
            }

            System.out.println(minimumBribes(q));
        }

    }

    // Complete the minimumBribes function below.
    static int minimumBribes(int[] q) {
        return 0;

    }

}