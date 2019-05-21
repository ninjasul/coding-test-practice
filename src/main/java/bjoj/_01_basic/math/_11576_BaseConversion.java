package bjoj._01_basic.math;/*
Base Conversion 성공

문제
뛰어난 프로그래머였던 정이는 A진법으로 나타낸 숫자를 B진법으로 변환시켜주는 프로그램을 작성하기로 하였다.
N진법이란, 한 자리에서 숫자를 표현할 때 쓸 수 있는 숫자의 가짓수가 N이라는 뜻이다.
예를 들어 N은 17일 때 한 자릿수에서 사용할 수 있는 수는 0, 1, 2, ... , 16으로 총 17가지가 된다.

입력
입력의 첫 줄에는 미래세계에서 사용하는 진법 A와 정이가 사용하는 진법 B가 공백을 구분으로 주어진다.
A와 B는 모두 2이상 30이하의 자연수다.

입력의 두 번째 줄에는 A진법으로 나타낸 숫자의 자리수의 개수 m(1 ≤ m ≤ 25)이 주어진다.
세 번째 줄에는 A진법을 이루고 있는 숫자 m개가 공백을 구분으로 높은 자릿수부터 차례대로 주어진다.
각 숫자는 0이상 A미만임이 보장된다. 또한 수가 0으로 시작하는 경우는 존재하지 않는다.

A진법으로 나타낸 수를 10진법으로 변환하였을 때의 값은 양의 정수이며 220보다 작다.

출력
입력으로 주어진 A진법으로 나타낸 수를 B진법으로 변환하여 출력한다.

예제 입력 1
17 8
2
2 16

예제 출력 1
6 2
*/

import java.util.Scanner;

public class _11576_BaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        sc.nextLine();
        int numCnt = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        int decimal = 0;
        for( int i = 0; i < numCnt; ++i ) {
            int curNum = sc.nextInt();
            decimal = decimal * from + curNum;
        }

        System.out.println(toBase(decimal, to));
    }

    private static String toBase( int number, int toBase ) {
        StringBuilder sb = new StringBuilder();

        while( number > 0 ) {
            sb.insert(0, (number%toBase) + " ");
            number = number/toBase;
        }

        return sb.toString();
    }

}