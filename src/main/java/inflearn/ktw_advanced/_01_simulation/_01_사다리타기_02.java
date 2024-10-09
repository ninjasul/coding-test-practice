package inflearn.ktw_advanced._01_simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_사다리타기_02 {
    private static int numberOfPlayers;
    private static List<List<Integer>> ladderLines = new ArrayList<>();
    private static char[] result;

    public static void main(String[] args) {
        numberOfPlayers = 5;
        ladderLines = List.of(
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 4)
        );
/*

        numberOfPlayers = 7;
        ladderLines = List.of(
            List.of(1, 3, 5),
            List.of(1, 3, 6),
            List.of(2, 4)
        );

        numberOfPlayers = 8;
        ladderLines = List.of(
            List.of(1, 5),
            List.of(2, 4, 7),
            List.of(1, 5, 7),
            List.of(2, 5, 7)
        );

        numberOfPlayers = 12;
        ladderLines = List.of(
            List.of(1, 5, 8, 10),
            List.of(2, 4, 7),
            List.of(1, 5, 7, 9, 11),
            List.of(2, 5, 7, 10),
            List.of(3, 6, 8, 11)
        );
*/

        initializePlayers();
        runLadder();
        printResult();
    }

    private static void initializePlayers() {
        result = new char[numberOfPlayers];
        for (int i = 0; i < result.length; ++i) {
            result[i] = (char) ('A' + i);
        }

        System.out.println(Arrays.toString(result));
    }

    private static void runLadder() {
        for (List<Integer> ladderLinesPerRow : ladderLines) {
            for (int ladderLine: ladderLinesPerRow) {
                swapPlayerPositions(ladderLine);
            }
        }
    }

    private static void swapPlayerPositions(int ladderLine) {
        char tempPosition;
        tempPosition = result[ladderLine - 1];
        result[ladderLine - 1] = result[ladderLine];
        result[ladderLine] = tempPosition;
    }

    private static void printResult() {
        System.out.println(Arrays.toString(result));
    }
}
