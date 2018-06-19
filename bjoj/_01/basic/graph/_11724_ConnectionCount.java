package _01.basic.graph;

/*
연결 요소의 개수

문제
방향 없는 그래프가 주어졌을 때,
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1
6 5
1 2
2 5
5 1
3 4
4 6

예제 출력 1
2
*/

import java.util.*;

public class _11724_ConnectionCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vCnt = sc.nextInt();
        int eCnt = sc.nextInt();

        List<List<Integer>> edgeLists = new ArrayList<List<Integer>>(vCnt+1);

        for( int i = 0; i <= vCnt; ++i ) {
            List<Integer> curEdgeList = new ArrayList<Integer>();
            edgeLists.add(curEdgeList);
        }

        for( int i = 0; i < eCnt; ++i ) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            List<Integer> curEdgeList = edgeLists.get(from);
            curEdgeList.add(to);

            curEdgeList = edgeLists.get(to);
            curEdgeList.add(from);
        }

        boolean [] hasVisited = new boolean[vCnt+1];
        int answer = 0;

        for( int i = 1; i <= vCnt; ++i ) {
            if( !hasVisited[i] ) {
                goDfs( i, edgeLists, hasVisited );
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void goDfs( int v, List<List<Integer>> edgeLists, boolean [] hasVisited ) {

        if( hasVisited[v] ) {
            return;
        }

        hasVisited[v] = true;

        for( int to : edgeLists.get(v) ) {
            if( !hasVisited[to] ) {
                goDfs( to, edgeLists, hasVisited );
            }
        }
    }


    private static void goBfs( int v, List<List<Integer>> edgeLists, boolean [] hasVisited ) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(v);
        hasVisited[v] = false;

        while( !deque.isEmpty() ) {

            for( int to : edgeLists.get(v) ) {
                if( !hasVisited[to] ) {
                    hasVisited[to] = true;
                    deque.addLast(to);
                }
            }

            v = deque.removeFirst();
        }
    }
}