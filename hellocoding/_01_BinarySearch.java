package hellocoding;
public class _01_BinarySearch {
	public static void main(String[] args) {
		int [] array = new int[] { 1, 3, 5, 7, 9 };
		System.out.println(doBinarySearch( array, 3));
		System.out.println(doBinarySearch( array, -1));
	}
	
	static int doBinarySearch(int [] array, int target ) {
		if( array == null || array.length <= 0 ) {
			return -1;
		}
		
		int low = 0;
		int high = array.length -1;
		int mid;
		int guess;  
				
		while( low <= high ) {
			mid = ( low + high ) / 2;
			guess = array[mid];
			
			if( guess == target ) {
				return mid;		
			}
			// 배열 수가 찾는 수보다 크면 찾는 수가 mid 왼쪽에 위치.
			// 따라서 high 값을 mid 왼쪽으로 조정
			else if( guess > target ) {
				high = mid-1;
			}
			// 배열 수가 찾는 수보다 작으면 찾는 수가 mid 오른쪽에 위치
			// 따라서 low 값을 mid 오른쪽으로 조정
			else {
				low = mid+1;
			}
		}
		
		return -1;
	}
}
