package _01.basic.sort;

/*
문제
영식이는 다음과 같은 버블 소트 프로그램을 C++로 작성했다.

bool change = false;
for (int i=1; i<=n+1; i++) {
    change = false;
    for (int j=1; j<=n-i; j++) {
        if (a[j] > a[j+1]) {
            change = true;
            swap(a[j], a[j+1]);
        }
    }
    if (change == false) {
        break;
    }
}
cout << i << '\n';

위 소스에서 n은 배열의 크기이고, a는 수가 들어있는 배열이다. 수는 배열의 1번방부터 채운다.
위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다.

출력
정답을 출력한다.
*/

import java.util.*;

public class _01377_BubbleSort {

    private static class Pair implements Comparable<Pair> {
        private int number;
        private int order;

        public Pair(int number, int order) {
            this.number = number;
            this.order = order;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(number, o.number);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        List<Pair> pairList = new ArrayList<Pair>(cnt+1);

        for( int i = 0; i < cnt; ++i ) {
            int number = sc.nextInt();
            pairList.add( i, new Pair( number, i ) );
        }

        Collections.sort(pairList);

        int answer = 0;
        for( int i = 0; i < cnt; ++i ) {
            Pair curPair = pairList.get(i);
            if( curPair.order - i > answer ) {
                answer = curPair.order-i;
            }
        }

        System.out.println(answer+1);
    }
}