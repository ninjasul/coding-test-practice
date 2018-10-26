package hackerrank.regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_DigitAndNonDigitCharacter {

    public static void main(String[] args) {
        check("([\\d]{2}\\D){2}[\\d]{4}");
    }

    public static void check(String pattern) {
        Scanner sc = new Scanner(System.in);
        String targetString = sc.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(targetString);

        System.out.println(m.matches());
    }

}