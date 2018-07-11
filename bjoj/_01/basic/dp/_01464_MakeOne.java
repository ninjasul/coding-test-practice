package _01.basic.dp;

/*
1로 만들기

문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
    2. X가 2로 나누어 떨어지면, 2로 나눈다.
    3. 1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
연산을 사용하는 횟수의 최소값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최소값을 출력한다.

예제 입력 1
2
예제 출력 1
1

예제 입력 2
10
예제 출력 2
3
*/

import java.util.Scanner;

public class _01464_MakeOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n+1];

        System.out.println(goBottomUp(n, d));
    }

    private static int goTopDown(int n, int[] d) {

        if( n == 1 ) {
            return 0;
        }

        if( d[n] > 0 ) {
            return d[n];
        }

        d[n] = goTopDown( n-1, d ) + 1;

        if( n%3 == 0 ) {
            int temp = goTopDown( n/3, d ) + 1;

            if( temp < d[n] ) {
                d[n] = temp;
            }
        }

        if( n%2 == 0 ) {
            int temp = goTopDown( n/2, d ) + 1;

            if( temp < d[n] ) {
                d[n] = temp;
            }
        }

        return d[n];
    }

    private static int goBottomUp( int n, int[] d ) {

        if( n == 1 ) {
            return 0;
        }

        d[1] = 0;

        for( int i = 2; i <= n; ++i ) {
            d[i] = d[i-1] + 1;

            if( i % 2 == 0 && d[i] > d[i/2] + 1 ) {
                d[i] = d[i/2] + 1;
            }

            if( i % 3 == 0 && d[i] > d[i/3] + 1 ) {
                d[i] = d[i/3] + 1;
            }
        }

        return d[n];
    }
}