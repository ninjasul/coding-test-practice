package hellocoding;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _04_QuickSearch {
	public static void main(String[] args) {
		int [] sortedArray = doQuickSort( new int[] { 10, 5, 2, 3, 4, 7, 8, 6 } );
		Arrays.stream(sortedArray).forEach(System.out::println);
	}

	public static int[] doQuickSort(int[] array ) {
		if( array == null || array.length < 2 ) {
			return array;
		}

		int pivot = array[0];
		int [] targetArray = Arrays.stream(array).skip(1).toArray();
		int [] lessArray = Arrays.stream(targetArray).filter( n -> n < pivot ).toArray();
		int [] greaterArray = Arrays.stream(targetArray).filter( n -> n >= pivot ).toArray();

		return Stream.of( Arrays.stream(doQuickSort(lessArray)), IntStream.of(pivot), Arrays.stream(doQuickSort(greaterArray))).flatMapToInt(s -> s).toArray();
	}
}
