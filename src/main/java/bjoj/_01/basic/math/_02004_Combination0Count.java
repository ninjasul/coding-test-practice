package bjoj._01.basic.math;

/*
조합 0의 개수

문제
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.

출력
첫째 줄에 0의 개수를 출력한다.

예제 입력 1
25 12

예제 출력 1
2
*/

import java.util.Scanner;

public class _02004_Combination0Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long numOf2 = getNumberOfN(n, 2) - getNumberOfN(m, 2) - getNumberOfN(n-m, 2);
        long numOf5 = getNumberOfN(n, 5) - getNumberOfN(m, 5) - getNumberOfN(n-m, 5);

        System.out.println( Math.min( numOf2, numOf5 ) );
    }

    public static long getNumberOfN( long n, int m ) {
        long result = 0;

        for( long i = m; i <= n; i*=m ) {
            result += n/i;
        }

        return result;
    }
}
