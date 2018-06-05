/*
2진수 8진수

문제
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.

예제 입력 1
11001100

예제 출력 1
314
*/

import java.util.Scanner;

public class _01373_BinaryToOctal {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for( int i = input.length()-1; i >= 0; i-=3 ) {
            int octal = 0;
            for( int j = i, k = 1; j >= 0 && j > i-3; --j, k <<= 1 ) {
                if( input.charAt(j) == '1' ) {
                    octal += k;
                }
                //System.out.println(octal);
            }
            sb.append(octal);
        }
        System.out.println(sb.reverse().toString());
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputLength = input.length();

        if( inputLength % 3 == 1 ) {
            System.out.print(input.charAt(0) - '0');
        }
        else if( inputLength % 3 == 2 ) {
            System.out.print((input.charAt(0) - '0')*2 + (input.charAt(1) - '0') );
        }

        for( int i = inputLength%3; i < inputLength; i+=3 ) {
            System.out.print((input.charAt(i) - '0')*4 + (input.charAt(i+1) - '0')*2 + (input.charAt(i+2) - '0') );
        }
        System.out.println();
    }
}