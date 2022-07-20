package bjoj._01_basic.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2251
 */

class WaterCapacityState {
    private int[] capacities;

    public WaterCapacityState(int[] capacities) {
        this.capacities = capacities;
    }

    public WaterCapacityState move(int from, int to, int[] limit) {
        int [] nextCapacities = capacities.clone();

        // 물을 붓다가 to쪽이 넘치는 경우
        if (nextCapacities[from] + nextCapacities[to] >= limit[to]) {
            nextCapacities[from] -= (limit[to] - nextCapacities[to]);
            nextCapacities[to] = limit[to];
        }
        // 물을 붓다가 from 쪽 물이 비는 경우
        else {
            nextCapacities[to] += nextCapacities[from];
            nextCapacities[from] = 0;
        }

        return new WaterCapacityState(nextCapacities);
    }

    public int getCapacity(int index) {
        return capacities[index];
    }
}

public class _02251_물통 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] maximumCapacities = new int[3];
    private static boolean[][][] visited = new boolean[201][201][201];
    private static boolean[] canBeAnswer = new boolean[201];
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        fillMaximumCapacities();
        goBfs(0, 0, maximumCapacities[2]);

        for (int i = 0; i <= maximumCapacities[2]; i++) {
            if (canBeAnswer[i]) {
                answer.append(i).append(' ');
            }
        }

        System.out.println(answer.toString());
    }

    private static void fillMaximumCapacities() {
        for (int i = 0, length = maximumCapacities.length; i < length; ++i) {
            maximumCapacities[i] = scanner.nextInt();
        }
    }

    private static void goBfs(int a, int b, int c) {
        Queue<WaterCapacityState> queue = new LinkedList<>();
        visited[a][b][c] = true;
        queue.add(new WaterCapacityState(new int[] {a, b, c}));

        while (!queue.isEmpty()) {
            WaterCapacityState state = queue.poll();

            if (state.getCapacity(0) == 0) {
                canBeAnswer[state.getCapacity(2)] = true;
            }

            for (int from = 0; from < 3; ++from) {
                for (int to = 0; to < 3; ++to) {
                    if (from == to) {
                        continue;
                    }

                    WaterCapacityState nextState = state.move(from, to, maximumCapacities);

                    if (!visited[nextState.getCapacity(0)][nextState.getCapacity(1)][nextState.getCapacity(2)]) {
                        visited[nextState.getCapacity(0)][nextState.getCapacity(1)][nextState.getCapacity(2)] = true;
                        queue.add(nextState);
                    }
                }
            }
        }
    }
}
