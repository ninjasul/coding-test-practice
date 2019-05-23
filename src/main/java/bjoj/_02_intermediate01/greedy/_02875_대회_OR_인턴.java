package bjoj._02_intermediate01.greedy;

/*
대회 or 인턴 성공

시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	5962	2645	2244	45.508%

문제
백준대학교에서는 대회에 나갈 때 2명의 여학생과 1명의 남학생이 팀을 결성해서 나가는 것이 원칙이다.
(왜인지는 총장님께 여쭈어보는 것이 좋겠다.)

백준대학교는 뛰어난 인재들이 많아 올해에도 N명의 여학생과 M명의 남학생이 팀원을 찾고 있다.

그런데 올해에는 대회에 참여하려는 학생들 중 K명을 반드시 인턴쉽 프로그램에 참여하라는 학교의 방침이 생기게 되었다.
인턴쉽에 참여하는 학생은 대회에 참여하지 못한다.

백준대학교에서는 뛰어난 인재들이 많기 때문에, 많은 팀을 만드는 것이 최선이다.

여러분은 N명의 여학생과 M명의 남학생, K명의 인턴쉽에 참여해야하는 인원이 주어질 때
만들 수 있는 최대의 팀 수를 구하면 된다.

입력
첫째 줄에 N, M, K가 순서대로 주어진다. (0 ≤ M ≤ 100), (0 ≤ N ≤ 100), (0 ≤ K ≤ M+N),

출력
만들 수 있는 팀의 최댓값을 출력하면 된다.

예제 입력 1
6 3 2

예제 출력 1
2
*/

import java.util.Scanner;

public class _02875_대회_OR_인턴 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int womenCount = sc.nextInt();
        int menCount = sc.nextInt();
        int internCount = sc.nextInt();
        int maxTeamCount = 0;

        while (womenCount >= 2 && menCount >= 1 && womenCount + menCount >= internCount + 3) {
            womenCount -= 2;
            menCount--;
            maxTeamCount++;
        }

        System.out.println(maxTeamCount);
    }
}