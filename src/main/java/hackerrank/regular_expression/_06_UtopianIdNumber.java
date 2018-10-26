package hackerrank.regular_expression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_UtopianIdNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for( int i = 0; i < n; ++i ) {
            String input = sc.nextLine();
            check( input, "^[a-z]{0,3}[0-9]{2,8}[A-Z]{3,}$" );
        }

    }

    private static void check(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        System.out.println(m.find() ? "VALID" : "INVALID");
    }
}