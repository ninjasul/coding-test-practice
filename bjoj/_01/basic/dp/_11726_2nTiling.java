package _01.basic.dp;

import java.util.*;

public class _11726_2nTiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n+1];

        d[0] = 1;
        d[1] = 1;

        for( int i = 2; i <= n; ++i ) {
            d[i] = d[i-1] + d[i-2];
        }

        System.out.println((d[n]%10007));
    }
}