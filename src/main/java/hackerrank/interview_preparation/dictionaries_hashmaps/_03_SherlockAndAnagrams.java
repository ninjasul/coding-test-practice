package hackerrank.interview_preparation.dictionaries_hashmaps;

import java.util.Arrays;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen
 */
public class _03_SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int length = s.length();

        int cnt = 0;
        for( int i = 1; i <= length-1; ++i ) {
            for( int j = 0; j < length - i; j++ ) {
                String source = s.substring( j, j+i );
                for( int k = j+1; k < length - i + 1; k++ ) {
                    String target = s.substring( k, k+i );
                    if( Arrays.equals(source.chars().sorted().toArray(), target.chars().sorted().toArray()) ) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
