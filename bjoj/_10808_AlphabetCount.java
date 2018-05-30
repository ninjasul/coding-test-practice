/**
알파벳 개수

 문제
알파벳 소문자로만 이루어진 단어 S가 주어진다.
 이 때, 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.

예제 입력 1
baekjoon

예제 출력 1
1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
*/

import java.util.Scanner;

public class _10808_AlphabetCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int [] alphabetCounts = new int[26];

        for( char curChar : input.toCharArray() ) {
            alphabetCounts[curChar-'a']++;
        }

        for( int curCount : alphabetCounts ) {
            System.out.print(curCount + " ");
        }
        System.out.println();
    }
}