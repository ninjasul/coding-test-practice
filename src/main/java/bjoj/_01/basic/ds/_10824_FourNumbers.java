package bjoj._01.basic.ds;/*
네 수

문제
네 자연수 A, B, C, D가 주어진다.
이 때, A와 B를 붙인 수와
C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.

두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다.
즉, 20과 30을 붙이면 2030이 된다.

입력
첫째 줄에 네 자연수 A, B, C, D가 주어진다.
(1 ≤ A, B, C, D ≤ 1,000,000)

출력
A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.

예제 입력 1
10 20 30 40

예제 출력 1
4060
*/


import java.util.Scanner;

public class _10824_FourNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        int b = sc.nextInt();
        long c = sc.nextInt();
        int d = sc.nextInt();

        int multiplier = 10;
        while (multiplier < b) {
            multiplier *= 10;
        }

        a *= multiplier;

        multiplier = 10;
        while (multiplier < d) {
            multiplier *= 10;
        }

        c *= multiplier;

        System.out.println(a + b + c + d);
    }
}