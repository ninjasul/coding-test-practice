package bjoj._01_basic.sort;

/*
K번째 수

문제
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때,
앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
둘째에는 A1, A2, ..., AN이 주어진다. (-10의 9승 ≤ Ai ≤ 10의 9승)

출력
A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

예제 입력 1
5 2
4 1 2 3 5

예제 출력 1
2
*/

import java.util.*;

public class _11004_KthNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] array = new int[n];

        for( int i = 0; i < n; ++i ) {
            array[i] = sc.nextInt();
        }

        System.out.println((doQuickSort( array, n, k ))[0]);
    }

    private static int [] doQuickSort( int [] array, int n, int k ) {

        if( array == null || array.length <= 0 ) {
            return null;
        }

        if( k <= 0 ) {
            return array;
        }

        int [] lessArray = new int[n];
        int [] greaterArray = new int[n];
        int pivot = array[0];

        int l = 0, m = 0;
        for( int i = 1; i < n; ++i ) {
            if( array[i] < pivot ) {
                lessArray[l++] = array[i];
            }
            else {
                greaterArray[m++] = array[i];
            }
        }

        // lessArray 개수가 k보다 크거나 같으면 lessArray 내에서 k번째 수를 찾으면 됨.
        if( l >= k ) {
            return doQuickSort( lessArray, l, k );
        }
        // lessArray 개수가 k보다 1 작으면 pivot 값이 k번째 수이므로 리턴.
        else if( l == k-1 ) {
            lessArray[0] = pivot;
            return lessArray;
        }
        // 나머지 케이스는 greaterArray 내에서 찾음. 이때 k번째 수가 아니라 k-l 에서 pivot 개수 1을 뺀 숫자를 찾도록 수정.
        else {
            return doQuickSort(greaterArray, m, k-l-1 );
        }
    }
}
