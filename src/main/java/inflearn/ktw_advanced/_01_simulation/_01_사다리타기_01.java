package inflearn.ktw_advanced._01_simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_사다리타기_01 {
    private static int numberOfPlayers;
    private static List<List<Integer>> ladderLines = new ArrayList<>();
    private static int[][] ladderMap;
    private static char[] result;

    public static void main(String[] args) {
        /*numberOfPlayers = 5;
        ladderLines = List.of(
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 4)
        );

        numberOfPlayers = 7;
        ladderLines = List.of(
            List.of(1, 3, 5),
            List.of(1, 3, 6),
            List.of(2, 4)
        );
*/
        /*numberOfPlayers = 8;
        ladderLines = List.of(
            List.of(1, 5),
            List.of(2, 4, 7),
            List.of(1, 5, 7),
            List.of(2, 5, 7)
        );*/

        numberOfPlayers = 12;
        ladderLines = List.of(
            List.of(1, 5, 8, 10),
            List.of(2, 4, 7),
            List.of(1, 5, 7, 9, 11),
            List.of(2, 5, 7, 10),
            List.of(3, 6, 8, 11)
        );

        runLadder();
    }

    private static void runLadder() {
        buildLadderMap();
        printLadderMap();
        calculateResult();
        printResult();
    }

    private static void buildLadderMap() {
        ladderMap = new int[ladderLines.size() + 1][numberOfPlayers + 1];

        for (int i = 1; i <= ladderLines.size(); ++i) {
            List<Integer> currentLadderLine = ladderLines.get(i - 1);
            for (int ladder : currentLadderLine) {
                ladderMap[i][ladder] = 1;
                if (ladder <= numberOfPlayers - 1) {
                    ladderMap[i][ladder + 1] = -1;
                }
            }
        }
    }

    private static void printLadderMap() {
        System.out.println(Arrays.deepToString(ladderMap));
    }

    private static void calculateResult() {
        result = new char[numberOfPlayers];
        for (int i = 1; i <= numberOfPlayers; ++i) {
            int currentColumn = i;
            int currentRow = 1;

            while (currentRow <= ladderLines.size()) {
                currentColumn += ladderMap[currentRow][currentColumn];
                currentRow++;
            }
            result[currentColumn - 1] = (char) ('A' + (i - 1));
        }
    }

    private static void printResult() {
        System.out.println(Arrays.toString(result));
    }
}
