package bjoj._01.basic.math;

import java.util.Scanner;

/*
팩토리얼 성공

문제
0보다 크거나 같은 정수 N이 주어진다.
이 때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.

예제 입력 1
10

예제 출력 1
3628800
*/
import java.util.Scanner;

public class _10872_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 1;
        for( int i = n; i > 1; --i ) {
            result *= i;
        }
        System.out.println(result);
    }
}