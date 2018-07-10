package _01.basic.dynamic;

import java.util.Scanner;

public class _11726_2nTiling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] d = new int [n+1];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;

        for( int i = 3; i <= n; ++i ) {
            d[i] = (d[i-1] + (i-2)) % 100007;
        }

        System.out.println(d[n]);

    }
}