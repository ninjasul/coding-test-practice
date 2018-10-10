package hackerank.interview_preparation;

import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

 */
public class _01_SockMerchant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] ar = new int[n];

        for( int i = 0; i < n; ++i ) {
            ar[i] = sc.nextInt();
        }
        sc.nextLine();

        System.out.println(sockMerchant(n, ar));
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        int [] countArray = new int[101];

        for( int i = 0; i < n; ++i ) {
            countArray[ar[i]]++;
        }

        int pairCount = 0;
        for( int i = 1; i <= 100; ++i ) {
            pairCount += (countArray[i]/2);
        }

        return pairCount;
    }
}
