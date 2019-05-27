package bjoj._02_intermediate01.greedy;

/*
행렬

문제
0과 1로만 이루어진 행렬 A와 행렬 B가 있다.
이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.

행렬을 변환하는 연산은 어떤 3*3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 -> 1, 1 -> 0)

입력
첫째 줄에 행렬의 크기 N M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에는 행렬 A가 주어지고, 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다. 만약 A를 B로 바꿀 수 없다면 -1을 출력한다.

예제 입력 1
3 4
0000
0010
0000
1001
1011
1001

예제 출력 1
2
*/

import java.util.Scanner;

public class _01080_행렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        boolean[][] srcMatrix = new boolean[row][col];
        initMatrix(sc, row, srcMatrix);

        boolean[][] destMatrix = new boolean[row][col];
        initMatrix(sc, row, destMatrix);

        int swapCount = 0;
        for (int i = 0; i < row-2; ++i) {
            for (int j = 0; j < col-2; ++j) {
                if (srcMatrix[i][j] != destMatrix[i][j]) {
                    swap(srcMatrix, i, j);
                    swapCount++;
                }
            }
        }

        if (equalsMatrix(srcMatrix, destMatrix)) {
            System.out.println(swapCount);
            return;
        }

        System.out.println(-1);
    }

    private static void initMatrix(Scanner sc, int row, boolean[][] matrix) {
        for (int i = 0; i < row; ++i) {
            String inputLine = sc.nextLine();
            int j = 0;
            for (char inputChar : inputLine.toCharArray()) {
                matrix[i][j] = (inputChar - '0') > 0;
                j++;
            }
        }
    }

    private static void swap(boolean[][] matrix, int startRowIndex, int startColIndex) {
        for (int i = startRowIndex; i < startRowIndex + 3; ++i) {
            for (int j = startColIndex; j < startColIndex + 3; ++j) {
                matrix[i][j] = !matrix[i][j];
            }
        }
    }

    private static boolean equalsMatrix(boolean[][] srcMatrix, boolean[][] destMatrix) {
        for (int i = 0, rowLength = srcMatrix.length; i < rowLength; ++i) {
            for (int j = 0, colLength = srcMatrix[0].length; j < colLength; ++j) {
                if (srcMatrix[i][j] != destMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}