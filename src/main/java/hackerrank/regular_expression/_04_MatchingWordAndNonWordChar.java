package hackerrank.regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_MatchingWordAndNonWordChar {

    public static void main(String[] args) {
        checker("(\\w){3}(\\W)(\\w){10}(\\W)(\\w){3}");
    }

    private static void checker(String pattern) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        System.out.println(m.find());
    }
}