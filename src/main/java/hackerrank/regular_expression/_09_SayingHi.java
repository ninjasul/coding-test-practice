package hackerrank.regular_expression;

import java.util.*;
import java.util.regex.*;

public class _09_SayingHi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; ++i) {
            String input = sc.nextLine();
            check(input, "^[H|h][I|i][\\s][^D|d][a-zA-Z]{0,9}([\\s][a-zA-Z]{1,10}){0,8}");
        }
    }

    private static void check(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if(m.find()) {
            System.out.println(input);
        }
    }
}