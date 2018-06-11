package _01.basic.sort;

/*
좌표 정렬하기

문제
2차원 평면 위의 점 N개가 주어진다.
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1
5
3 4
1 1
1 -1
2 2
3 3

예제 출력 1
1 -1
1 1
2 2
3 3
3 4
*/

import java.util.*;

public class _11650_SortCoordinate {
    private static class Coordinate implements Comparable<Coordinate>
    {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Coordinate c) {
            int result = 0;
            if( x < c.x ) {
                return -1;
            }
            else if( x > c.x ){
                return 1;
            }
            else {
                return ( ( y < c.y ) ? -1 : ( y > c.y ? 1 : 0 ) );
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<Coordinate> list = new ArrayList<Coordinate>();

        for( int i = 0; i < cnt; ++i ) {
            list.add(new Coordinate( sc.nextInt(), sc.nextInt()) );
        }

        Collections.sort(list);
        //Collections.sort(list, Collections.reverseOrder());

        for( Coordinate c : list ) {
            System.out.println(c.toString());
        }
    }
}