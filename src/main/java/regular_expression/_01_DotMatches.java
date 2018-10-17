package regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem?h_r=next-challenge&h_v=zen
*/
public class _01_DotMatches {

    public static void main(String[] args) {
        _01_DotMatches tester = new _01_DotMatches();
        tester.checker("([^\\n]{3}\\.){3}[^\\n]{3}");
    }

    public void checker(String pattern) {
        Scanner sc = new Scanner(System.in);
        String targetString = sc.nextLine();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(targetString);
        System.out.println(m.matches());
    }
}