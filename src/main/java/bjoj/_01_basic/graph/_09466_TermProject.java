package bjoj._01_basic.graph;

/*
텀 프로젝트

문제
이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다.
프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다.
프로젝트 팀을 구성하기 위해, 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택해야 한다. (단, 단 한명만 선택할 수 있다.)
혼자 하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.

학생들이(s1, s2, ..., sr)이라 할 때, r=1이고 s1이 s1을 선택하는 경우나,
s1이 s2를 선택하고, s2가 s3를 선택하고,..., sr-1이 sr을 선택하고, sr이 s1을 선택하는 경우에만 한 팀이 될 수 있다.

예를 들어, 한 반에 7명의 학생이 있다고 하자. 학생들을 1번부터 7번으로 표현할 때, 선택의 결과는 다음과 같다.

1	2	3	4	5	6	7
3	1	3	7	3	4	6

위의 결과를 통해 (3)과 (4, 7, 6)이 팀을 이룰 수 있다. 1, 2, 5는 어느 팀에도 속하지 않는다.

주어진 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스의 첫 줄에는 학생의 수가 정수 n (2 ≤ n ≤ 100,000)으로 주어진다.
각 테스트 케이스의 둘째 줄에는 선택된 학생들의 번호가 주어진다. (모든 학생들은 1부터 n까지 번호가 부여된다.)

출력
각 테스트 케이스마다 한 줄에 출력하고, 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수를 나타내면 된다.

예제 입력 1
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8

예제 출력 1
3
0
*/

/*

public class _09466_TermProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();

        for( int i = 0; i < testCnt; ++i ) {
            int vCnt = sc.nextInt();
            int [] edgeArray = new int[vCnt+1];
            int [] visitCnts = new boolean[vCnt+1];
            int [] teamArray = new int[vCnt+1];

            for( int j = 1; j <= vCnt; ++j ) {
                edgeArray[j] = sc.nextInt();
            }

            int answer = 0;

            for( int j = 1; j <= vCnt; ++j ) {

                if( visitCnts[edgeArray[j]]  == 0) {
                    goDfs(edgeArray[j], edgeArray, teamArray, visitCnts );
                }

                //Arrays.fill(hasVisited, false);
            }

            System.out.println(answer);
        }
    }

    private static void goDfs( int v, int[] edgeArray, int[] teamArray, int[] visitCnts ) {

        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.addFirst(v);

        while( !deque.isEmpty() ) {
            int curV = deque.removeFirst();

            if( !visitCnts[curV] ) {
                hasVisited[curV] = true;
                deque.addFirst(edgeArray[curV]);
            }

            if( teamArray[curV] )
            hasVisited[v] = true;
            v = edgeArray[v];
        } while( !hasVisited[v] );
    }
}*/
