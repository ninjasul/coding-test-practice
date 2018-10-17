package hackerrank.interview_preparation.dictionaries_hashmaps;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/*
https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
*/
public class _05_FrequencyQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            queries.add(
                    Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
            );
        });

        List<Integer> ans = freqQuery(queries);

        System.out.printf("%s",
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> queryMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for( List<Integer> queryList : queries ) {
            int query = queryList.get(0);
            int key = queryList.get(1);
            //System.out.printf("Query: %d, Key: %d\n", query, key);

            switch(query) {
                case 1:
                    if( !queryMap.containsKey(key)) {
                        queryMap.put(key, 1);
                    }
                    else {
                        queryMap.put(key, queryMap.get(key)+1);
                    }
                    break;

                case 2:
                    if( queryMap.containsKey(key) ) {
                        int frequency = queryMap.get(key);

                        if( frequency > 1 ) {
                            queryMap.put(key, frequency-1);
                        }
                        else {
                            queryMap.remove(key);
                        }
                    }
                    break;

                case 3:
                    answerList.add( queryMap.entrySet().stream().filter(e -> e.getValue() == key).findFirst().isPresent() ? 1 : 0);
                    break;
            }

/*
            queryMap.entrySet().forEach(entry -> {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            });
            System.out.println();
*/
        }

        return answerList;
    }
}