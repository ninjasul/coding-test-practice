package _01.basic.graph;


/*
미로 탐색

문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다.
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1
4 6
101111
101010
101011
111011

예제 출력 1
15

예제 입력 2
4 6
110110
110110
111111
111101

예제 출력 2
9
*/

import java.util.*;

public class _02178_Maze {

    private static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static final int [] dx = { -1, 1, 0, 0 };
    private static final int [] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int [][] map = new int[n+2][m+2];

        for( int i = 1; i <= n; ++i ) {
            String line = sc.nextLine();
            for( int j = 1; j <= m; ++j ) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        goBfs(1, 1, map);
        System.out.println(map[n][m]);
    }

    public static void goBfs( int i, int j, int [][] map ) {

        Deque<Pos> deque = new ArrayDeque<Pos>();
        deque.addFirst( new Pos( j, i ) );
        //map[i][j]++;

        while( !deque.isEmpty() ) {

            Pos curPos = deque.removeFirst();

            for( int k = 0; k < 4; ++k ) {
                int x = curPos.x + dx[k];
                int y = curPos.y + dy[k];

                if( map[y][x] == 1 ) {
                    deque.addLast(new Pos(x, y));
                    map[y][x] = map[curPos.y][curPos.x] + 1;
                }
            }
        }
    }
}