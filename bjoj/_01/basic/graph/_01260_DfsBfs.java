package _01.basic.graph;

/*
질문 검색
DFS와 BFS

문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다.
입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를,
그 다음 줄에는 BFS를 수행한 결과를 출력한다.
V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1
4 5 1
1 2
1 3
1 4
2 4
3 4

예제 출력 1
1 2 4 3
1 2 3 4
*/

import java.util.*;

public class _01260_DfsBfs {
    private static boolean [] hasVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vCnt = sc.nextInt();
        int eCnt = sc.nextInt();
        int start = sc.nextInt();

        List<List<Integer>> edgeList = new ArrayList<List<Integer>>(vCnt+1);

        for( int i = 0; i <= vCnt; ++i ) {
            List<Integer> curList = new ArrayList<Integer>();
            edgeList.add(i, curList);
        }

        for( int i = 0; i < eCnt; ++i ) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            List<Integer> curList = edgeList.get(from);
            curList.add(to);

            curList = edgeList.get(to);
            curList.add(from);
        }

        for( List<Integer> curVList : edgeList ) {
            Collections.sort(curVList);
        }

        hasVisited = new boolean[vCnt+1];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        goDfs( start, edgeList );
        System.out.println();

        Arrays.fill( hasVisited, false );
        goBfs( start, edgeList );
    }

    private static void goDfs( int v, List<List<Integer>> edgeList ) {

        if( hasVisited[v] ) {
            return;
        }

        hasVisited[v] = true;
        System.out.print(v + " ");

        for( int to : edgeList.get(v) ) {
            goDfs( to, edgeList );
        }
    }

    private static void goBfs( int v, List<List<Integer>> edgeList ) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(v);
        hasVisited[v] = true;

        while( !queue.isEmpty() ) {
            int to = queue.remove();
            System.out.print( to + " " );

            for( int n : edgeList.get(to) ) {
                if( !hasVisited[n] ) {
                    hasVisited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}