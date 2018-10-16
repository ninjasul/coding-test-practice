package interview_preparation.array;
/*
https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
*/

import java.util.Scanner;

public class _01_2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] inputLines = sc.nextLine().split(" ");

            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(inputLines[j]);
            }
        }

        System.out.println(hourglassSum(arr));
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int sum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for( int i = 0; i < 4; ++i ) {
            for( int j = 0; j < 4; ++j ) {
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                maxSum = Math.max( maxSum, sum );
            }
        }

        return maxSum;
    }
}