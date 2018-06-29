package _01.basic.graph;

/*
다리 만들기 - https://www.acmicpc.net/problem/2146

문제
여러 섬으로 이루어진 나라가 있다.
이 나라의 대통령은, 섬들을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다.
하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다.

그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고,
그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다.
이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다.
다음은 세 개의 섬으로 이루어진 나라의 지도이다.



위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다.
이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다.
가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다.
다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.



물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나,
위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

입력
첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며,
0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

출력
첫째 줄에 가장 짧은 다리의 길이를 출력한다.

예제 입력 1
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

예제 출력 1
3
*/

import java.util.*;

public class _02146_BuildingBridges {

    private static class Pos {
        int x;
        int y;
        int islandNo;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pos(int x, int y, int islandNo) {
            this.x = x;
            this.y = y;
            this.islandNo = islandNo;
        }
    }

    private static int [] dx = { 0, 1, 0, -1 };
    private static int [] dy = { -1, 0, 1, 0 };
    private static int size;
    private static Deque<Pos> distanceDeque = new ArrayDeque<Pos>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int [][] map = new int[size][size];
        int [][] group = new int[size][size];
        int [][] distance = new int[size][size];

        for( int i = 0; i < size; ++i ) {
            for( int j = 0; j < size; ++j ) {
                map[i][j] = sc.nextInt();
            }
        }

        Deque<Pos> deque = new ArrayDeque<Pos>();
        int islandNo = -1;
        for( int i = 0; i < size; ++i ) {
            for( int j = 0; j < size; ++j ) {
                if( map[i][j] == 1 ) {
                    deque.addLast( new Pos( j, i ) );
                    fillGroup( islandNo--, deque, map, group, distance );
                }
            }
        }

        fillDistance( map, group, distance );

        int answer = getShortestDistance( group, distance );

        System.out.println(answer);
    }

    private static void fillGroup( int islandNo, Deque<Pos> deque, int [][] map, int [][] group, int [][] distance ) {

        while( !deque.isEmpty() ) {
            Pos curPos = deque.removeFirst();

            for( int k = 0; k < 4; ++k ) {
                int x = curPos.x + dx[k];
                int y = curPos.y + dy[k];

                if( x >= 0 && x < size && y >= 0 && y < size ) {
                    if( map[y][x] == 1 ) {
                        deque.addLast( new Pos( x, y ) );
                        group[y][x] = islandNo;
                        distance[y][x] = -1;
                    }
                    else if( map[y][x] == 0 ) {
                        distance[y][x] = 1;
                        group[y][x] = islandNo;
                        distanceDeque.addLast( new Pos( x, y, islandNo ) );
                    }
                }
            }
        }
    }

    private static void fillDistance( int [][] map, int [][] group, int[][] distance ) {

        while( !distanceDeque.isEmpty() ) {

            Pos curPos = distanceDeque.removeFirst();

            for (int k = 0; k < 4; ++k) {
                int x = curPos.x + dx[k];
                int y = curPos.y + dy[k];

                if (x >= 0 && x < size && y >= 0 && y < size) {
                    if (group[y][x] == 0 && distance[y][x] == 0 ) {
                        distanceDeque.addLast(new Pos(x, y, curPos.islandNo));
                        distance[y][x] = distance[curPos.y][curPos.x] + 1;
                        group[y][x] = curPos.islandNo;
                    }
                }
            }

           for( int n = 0; n < size; ++n ) {
                for( int m = 0; m < size; ++m ) {
                    System.out.printf("%2d ", group[n][m]);
                }
                System.out.println();
            }
            System.out.println();

            for( int n = 0; n < size; ++n ) {
                for( int m = 0; m < size; ++m ) {
                    System.out.printf("%2d ", distance[n][m]);
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    private static int getShortestDistance( int [][] group, int [][] distance ) {

        int result = Integer.MAX_VALUE;

        for( int i = 0; i < size; ++i ) {
            for( int j = 0; j < size; ++j ) {
                for( int k = 0; k < 4; ++k ) {
                    int x = j + dx[k];
                    int y = i + dy[k];

                    if( x >= 0 && x < size && y >= 0 && y < size ) {
                        if (group[i][j] != group[y][x]) {
                            result = Math.min(result, distance[i][j] + distance[y][x]);
                        }
                    }
                }
            }
        }

        return result;
    }
}