package bjoj._01_basic.math;/*
진법 변환

문제
B진법 수 N이 주어진다.
이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

출력
첫째 줄에 B진법 수 N을 10진법으로 출력한다.

예제 입력 1
ZZZZZ 36

예제 출력 1
60466175
*/

import java.util.Scanner;

public class _02745_ToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        int fromRadix = Integer.parseInt(input[1]);
        int result = 0;
        int multiplier = 1;

        for( int i = input[0].length()-1; i >= 0; --i ) {
            char curChar = input[0].charAt(i);

            if( curChar >= 'A' && curChar <= 'Z' ) {
                result += (((int)(curChar-'A')+10) * multiplier);
            }
            else {
                result += ((int)(curChar-'0') * multiplier);
            }
            multiplier *= fromRadix;
        }

        System.out.println(result);
    }
}