package hackerrank.interview_preparation.array;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MinimunSwaps2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];

        String[] arrItems = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
    }

    private static int minimumSwaps(int[] arr) {

        int length = arr.length;
        int [] sortedArray = Arrays.copyOf( arr, length );
        Arrays.sort(sortedArray);

        boolean [] swapped = new boolean[length];

        int swapCnt = 0;
        for( int i = 0; i < length; ++i ) {

            System.out.println("arr[" + i + "]: " + arr[i]);
            System.out.println("arr[arr[" + i + "]-1]: " + arr[arr[i]-1]);

            if( swapped[i] == false && arr[i] != sortedArray[i] ) {
                swapCnt++;
                if( swapped[arr[i]-1] == false && (i+1) != arr[arr[i]-1] ) {
                }
            }

            swapped[i] = true;
        }

        return swapCnt;
    }


}
