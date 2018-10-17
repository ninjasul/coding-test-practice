package bjoj._01.basic.math;/*
8진수 2진수 실패

문제
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.

출력
첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.

예제 입력 1
314

예제 출력 1
11001100
*/

import java.util.Scanner;

public class _01212_OctalToBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] octalBinaries = { "000", "001", "010", "011", "100", "101", "110", "111" };

        StringBuilder sb = new StringBuilder();
        for (char curChar : input.toCharArray()) {
            sb.append(octalBinaries[curChar-'0']);
        }

        String result = sb.toString();
        if( result.indexOf("1") < 0 ) {
            System.out.println("0");
        }
        else {
            System.out.println(result.substring(result.indexOf("1")));
        }
    }
}