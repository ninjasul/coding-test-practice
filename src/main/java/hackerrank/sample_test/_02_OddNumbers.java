package hackerrank.sample_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_OddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        sc.nextLine();
        int r = sc.nextInt();
        sc.nextLine();

        for( int i : oddNumbers(l, r) ) {
            System.out.println(i);
        }
    }

    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {

        if( l%2 == 0 ) {
            l++;
        }

        if( r%2 == 0 ) {
            r--;
        }

        List<Integer> list = new ArrayList<>();
        for( int i = l; i <= r; i+=2 ) {
            list.add(i);
        }

        return list;
    }


}
