package bjoj._01_basic.graph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class _01260_DFS와_BFS {
    private static Scanner scanner = new Scanner(System.in);
    private static int vertexCount;
    private static int edgeCount;
    private static int startVertex;
    private static List<List<Integer>> graph;
    private static boolean [] visited;
    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        graph = buildGraph();
        //System.out.println(graph);
        visited = new boolean[vertexCount+1];

        goDfs(graph, startVertex);
        System.out.println();
        Arrays.fill(visited, false);

        goBfs(graph, startVertex);
    }

    private static List<List<Integer>> buildGraph() {
        vertexCount = scanner.nextInt();
        edgeCount = scanner.nextInt();
        startVertex = scanner.nextInt();
        scanner.nextLine();

        graph = new ArrayList<>(vertexCount);

        IntStream.rangeClosed(0, vertexCount)
                .forEach(index -> {
                    graph.add(index, new ArrayList<>());
                });

        IntStream.rangeClosed(1, edgeCount)
                .forEach(number -> {
                    int from = scanner.nextInt();
                    int to = scanner.nextInt();
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                    scanner.nextLine();
                });

        graph.forEach(Collections::sort);

        return graph;
    }

    private static void goDfs(List<List<Integer>> graph, int vertex) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int to : graph.get(vertex)) {
            goDfs(graph, to);
        }
    }

    private static void goBfs(List<List<Integer>> graph, int vertex) {
        Deque<Integer> queue = new ArrayDeque<>(vertexCount);
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int to = queue.remove();
            System.out.print(to + " ");

            for (int next: graph.get(to)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
