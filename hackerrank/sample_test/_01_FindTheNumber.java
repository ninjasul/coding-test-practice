package hackerrank.sample_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_FindTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> arr = new ArrayList<>();

        for( int i = 0; i < n; ++i ) {
            arr.add(sc.nextInt());
            sc.nextLine();
        }

        int k = sc.nextInt();

        System.out.println(findNumber( arr, k ));
    }

    static String findNumber(List<Integer> arr, int k) {

        boolean found = false;
        for( int i : arr ) {
            if( i == k ) {
                found = true;
                break;
            }
        }

        return (found) ? "YES" : "NO";
    }


}
