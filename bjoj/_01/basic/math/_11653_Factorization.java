package _01.basic.math;

/*
소인수분해

문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 인수를 한 줄에 하나씩 증가하는 순서대로 출력한다.

예제 입력 1
72
예제 출력 1
2
2
2
3
3

예제 입력 2
3
예제 출력 2
3

예제 입력 3
6
예제 출력 3
2
3

예제 입력 4
2
예제 출력 4
2

예제 입력 5
9991
예제 출력 5
97
103
 */

import java.util.Scanner;

public class _11653_Factorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for( int i = 2; i <= number && number > 1; ) {
            if( number % i == 0 ) {
                System.out.println(i);
                number /= i;
            }
            else {
                i++;
            }
        }
    }
}