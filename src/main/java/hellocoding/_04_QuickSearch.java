package hellocoding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _04_QuickSearch {
	public static void main(String[] args) {
		int [] sortedArray = doQuickSort( new int[] { 10, 5, 2, 3, 4, 7, 8, 6 } );
		
		for( int i : sortedArray ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static int[] doQuickSort( int[] array ) {
		if( array == null || array.length < 2 ) {
			return array;
		}
		else {
			int pivot = array[0];
			int [] lessArray = Arrays.stream(array).filter(x -> x < pivot).toArray();
			int [] greaterArray = Arrays.stream(array).filter(x -> x > pivot).toArray();
			
			return IntStream
					.concat(Arrays.stream(doQuickSort( lessArray )), 
								IntStream.concat(
									IntStream.of(pivot), 
									Arrays.stream(doQuickSort( greaterArray ))
								)
							).toArray();
		}
	}
}
