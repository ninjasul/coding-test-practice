import java.util.Arrays;
import java.util.Scanner;

public class _04_MinimumSwaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int [] arr = new int[n];
        String[] nums = sc.nextLine().split(" ");

        for( int i = 0; i < n; ++i ) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        System.out.println(minimumSwaps(arr));

    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, length);
        Arrays.sort(sortedArr);

        int swapCnt = 0;
        for( int i = 0; i < length; ++i ) {
            if( arr[i] != sortedArr[i] ) {
                swapCnt++;
            }
        }

        return swapCnt-1;
    }
}