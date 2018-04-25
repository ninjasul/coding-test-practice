package leetcode;
public class _0007_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(-2147483412));
		System.out.println(reverse(2147483417));
	}
	
	static public int reverse(int x) {
		
		int returnValue = 0;
				
		while( x != 0 ) {
			int tail = x % 10;
			int newReturnValue = returnValue * 10 + tail;
			
			System.out.println("(newReturnValue-tail) / 10: " + (newReturnValue-tail) / 10);
			System.out.println("returnValue: " + returnValue);
			if( (newReturnValue-tail) / 10 != returnValue ) {
				return 0;
			}
			returnValue = newReturnValue;
			x /= 10;			
		}
				
		return returnValue;
	}
}
