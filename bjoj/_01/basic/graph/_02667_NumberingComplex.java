package _01.basic.graph;

/*
단지번호붙이기

문제
<그림 1>과 같이 정사각형 모양의 지도가 있다.
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.

대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.


입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

예제 출력 1
3
7
8
9
*/

import java.util.*;

public class _02667_NumberingComplex {

    private static int [] dy = new int [] { 1, -1, 0, 0 };
    private static int [] dx = new int [] { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int [][] map = new int[n+2][n+2];

        for( int i = 1; i <= n; ++i ) {
            String line = sc.nextLine();

            for( int j = 1; j <= n; ++j ) {
                map[i][j] = ( line.charAt(j-1) == '1' ) ? 1 : 0;
            }
        }

        List<Integer> complexList = new ArrayList<Integer>();

        for( int i = 1; i <= n; ++i ) {
            for( int j = 1; j <= n; ++j ) {
                if( map[i][j] == 1 )
                    complexList.add(goBfs(i, j, map));
            }
        }

        Collections.sort( complexList );
        System.out.println(complexList.size());
        for( int i : complexList ) {
            System.out.println(i);
        }
    }

    private static int goBfs( int i, int j, int[][] map ) {

        int houseCnt = 0;

        Deque<Integer> deque1 = new ArrayDeque<Integer>();
        Deque<Integer> deque2 = new ArrayDeque<Integer>();

        if( map[i][j] == 1 ) {
            deque1.addFirst(i);
            deque2.addFirst(j);
            map[i][j]++;
        }

        while( !deque1.isEmpty() && !deque2.isEmpty() ) {

            i = deque1.removeFirst();
            j = deque2.removeFirst();

            map[i][j]++;
            houseCnt++;

            for( int k = 0; k < 4; ++k ) {

                int y = i + dy[k];
                int x = j + dx[k];

                if( map[y][x] == 1 ) {
                    deque1.addLast(y);
                    deque2.addLast(x);
                    map[y][x]++;
                }
            }
        }

        return houseCnt;
    }
}
