package interview_preparation.array;

import java.util.Arrays;
import java.util.Scanner;

public class _02_LeftRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();

        int[] a = new int[n];

        for( int i = 0; i < n; ++i ) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();

        System.out.println(Arrays.toString(rotLeft(a, d)));
    }

    private static int[] rotLeft(int[] a, int d) {
        int length = a.length;
        int [] arr = new int[length];

        for( int i = 0; i < length; ++i ) {
            arr[i] = a[(i+d)%length];
        }

        return arr;
    }
}