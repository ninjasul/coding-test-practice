package bjoj._01.basic.math;

/*
팩토리얼 0의 개수 성공

문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1
10

예제 출력 1
2
*/

import java.util.Scanner;

public class _01676_Factorial0Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNumberOfZero(n));
    }

    /*public static int getNumberOfZero( int n ) {

        int num2Cnt = 0;
        int num5Cnt = 0;

        for( int i = 2; i <= n; ++i ) {
            int result = i;
            while( result > 1 ) {
                if( result % 2 == 0 ) {
                    num2Cnt++;
                    result >>= 1;
                    continue;
                }

                if( result % 5 == 0 ) {
                    num5Cnt++;
                    result = result / 5;
                    continue;
                }

                break;
            }
        }

        return Math.min(num5Cnt, num2Cnt);
    }*/

    public static int getNumberOfZero( int n ) {
        int result = 0;
        for( int i = 5; i <= n; i*=5 ) {
            result += n/i;
        }
        return result;
    }
}