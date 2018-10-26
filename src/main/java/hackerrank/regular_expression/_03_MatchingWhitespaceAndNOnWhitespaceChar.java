package hackerrank.regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_MatchingWhitespaceAndNOnWhitespaceChar {

    public static void main(String[] args) {
        checker("((\\w){2}(\\W)){2}(\\w){2}");
    }

    public static void checker( String regexPattern ) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(input);
        System.out.println(m.find());
    }
}