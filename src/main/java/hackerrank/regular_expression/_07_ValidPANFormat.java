package hackerrank.regular_expression;

import java.util.*;
import java.util.regex.*;

public class _07_ValidPANFormat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for( int i = 0; i < n; ++i ) {
            String input = sc.nextLine();
            check( input, "^[A-Z]{5}[0-9]{4}[A-Z]{1}$" );
        }
    }

    private static void check(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        System.out.println(m.find() ? "YES" : "NO");
    }
}