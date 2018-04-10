import java.util.Arrays;

public class _02_SelectionSort {
	public static void main(String[] args) {
		int [] array = new int[] { 3, 4, 2, 1 };
		doSelectionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void doSelectionSort( int[] array ) {
		if( array == null || array.length <= 1 ) 
			return;
		
		int length = array.length;
		int temp;
		int minIndex;
 
		for( int i = 0; i < length-1; ++i ) {
			
			minIndex = i;
			
			for( int j = i+1; j < length; ++j ) {
				if( array[minIndex] > array[j] ) {
					minIndex = j;
				}
			}
			
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
			
		}
	}
}
