package bjoj._01.basic.sort;

/*
카드

문제
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데,
적혀있는 수는 -2의 62승보다 크거나 같고, 2의 62승 보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
만약, 가장 많이 가지고 있는 정수가 여러가지라면, 작은 것을 출력한다.

입력
첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 <= N <= 1000000)이 주어진다.
둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.

출력
첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.

예제 입력 1
5
1
2
1
2
1

예제 출력 1
1

예제 입력 2
6
1
2
1
2
1
2

예제 출력 2
1
*/

import java.math.BigInteger;
import java.util.*;

public class _11652_Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        Map<BigInteger, Integer> cardMap = new HashMap<BigInteger, Integer>();
        int maxCnt = 0;
        BigInteger max = null;

        for (int i = 0; i < cnt; ++i) {
            BigInteger num = sc.nextBigInteger();

            if (cardMap.containsKey(num)) {
                cardMap.replace(num, cardMap.get(num) + 1);
            } else {
                cardMap.put(num, 1);
            }

            int count = cardMap.get(num);
            if( count > maxCnt || ( count == maxCnt && num.compareTo(max) < 0 ) ) {
                max = num;
                maxCnt = cardMap.get(num);
            }
        }

        if( max != null ) {
            System.out.println(max);
        }
    }
}