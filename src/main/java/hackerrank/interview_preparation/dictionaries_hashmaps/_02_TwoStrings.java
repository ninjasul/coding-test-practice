package hackerrank.interview_preparation.dictionaries_hashmaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class _02_TwoStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        sc.nextLine();

        for (int qItr = 0; qItr < q; qItr++) {
            System.out.println(twoStrings(sc.nextLine(), sc.nextLine()));
        }

    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Character> set1 = new HashSet<>(s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
        Set<Character> set2 = new HashSet<>(s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
        set1.retainAll(set2);
        return set1.size() > 0 ? "YES" : "NO";
    }


}
