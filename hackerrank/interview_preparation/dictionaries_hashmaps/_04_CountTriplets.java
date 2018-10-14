package hackerrank.interview_preparation.dictionaries_hashmaps;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class _04_CountTriplets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long r = sc.nextLong();
        sc.nextLine();

        List<Long> arr = Stream.of(sc.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(toList());

        System.out.println(countTriplets(arr, r));

    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        int size = arr.size();
        int tripletsCnt = 0;
        for( int i = 0; i < size-2; ++i ) {
            long first = exponentialNumber(r, arr.get(i));

            if( first >= 0 ) {
                for (int j = 1; j < size - 1; ++j) {

                    long second = exponentialNumber(r, arr.get(j));

                    if( ( r == 1 && first == 0 && second == 0 ) || second == first + 1 ) {
                        for (int k = 2; k < size; ++k) {
                            long third = exponentialNumber(r, arr.get(k));
                            if ( ( r == 1 && first == 0 && second == 0 && third == 0 ) || third == second + 1 ) {
                                tripletsCnt++;
                            }
                        }
                    }
                }
            }
        }

        return tripletsCnt;
    }

    static long exponentialNumber( long base, long target ) {

        if( target == 1 ) {
            return 0;
        }

        long num = -1;
        while( target%base == 0 ) {
            target /= base;
            num = (num == -1) ? 1 : num+1;
        }
        return num;
    }

}
