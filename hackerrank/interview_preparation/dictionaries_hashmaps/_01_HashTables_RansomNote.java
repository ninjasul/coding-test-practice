package hackerrank.interview_preparation.dictionaries_hashmaps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _01_HashTables_RansomNote {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");

        checkMagazine(magazine, note);
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Long> magazineMap = Arrays.asList(magazine).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean containsAll = true;
        for( String str : note ) {

            if (magazineMap.containsKey(str) ) {
                long count = magazineMap.get(str);
                if( count > 1 ) {
                    magazineMap.put(str, count - 1);
                }
                else {
                    magazineMap.remove(str);
                }
            }
            else {
                containsAll = false;
                break;
            }
        }

        System.out.println(containsAll ? "Yes" : "No");
    }
}
