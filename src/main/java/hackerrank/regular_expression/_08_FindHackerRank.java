package hackerrank.regular_expression;

import java.util.Scanner;

public class _08_FindHackerRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for( int i = 0; i < n; ++i ) {
            String input = sc.nextLine();
            System.out.println(check( input, "hackerrank" ));
        }
    }

    private static int check(String input, String pattern) {
        boolean isStartsWith = input.startsWith(pattern);
        boolean isEndsWith = input.endsWith(pattern);

        if( isStartsWith && isEndsWith ) {
            return 0;
        }
        else if( isStartsWith ) {
            return 1;
        }
        else if( isEndsWith ) {
            return 2;
        }
        else {
            return -1;
        }
    }

}