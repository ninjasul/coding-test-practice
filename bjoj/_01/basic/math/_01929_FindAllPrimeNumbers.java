package _01.basic.math;

/*
소수 구하기 성공

문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1
3 16

예제 출력 1
3
5
7
11
13
*/


import java.util.Arrays;
import java.util.Scanner;

public class _01929_FindAllPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();

        boolean [] isPrimeNumber = new boolean[to+1];
        Arrays.fill( isPrimeNumber, true );
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;

        for( int i = 2; i <= to; ++i ) {
            if( !isPrimeNumber[i] )
                continue;

            for( int j = i<<1; j <= to; j+=i ) {
                isPrimeNumber[j] = false;
            }
        }

        for( int i = from; i <= to; ++i ) {
            if( isPrimeNumber[i] ) {
                System.out.println(i);
            }
        }
    }
}