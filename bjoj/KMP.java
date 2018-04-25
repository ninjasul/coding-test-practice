package bjoj;
import java.util.ArrayList;
import java.util.List;

public class KMP {
	public static void main(String[] args) {
		String target = "ABABABABBABABABABC";
		String pattern = "ABABABABC";		
		
		List<Integer> answerList = kmp( target, pattern );
		
		for( int i : answerList ) {
			System.out.println( i + ": " + target.substring(i));
		}
		System.out.println();
	}
	
	private static int [] getPi(String pattern) {
		
		if( pattern == null || pattern.length() == 0 ) return null;
		int len = pattern.length();
		int [] pi = new int[len];
		int j = 0;

		printString("pattern: ", pattern);
		
		for( int i = 1; i < len; ++i ) {
			
			System.out.println("getPi #1: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", P[" + i + "]: " + pattern.charAt(i) );
			
			while( j > 0 && pattern.charAt(i) != pattern.charAt(j) ) {
				System.out.println("getPi #2: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", P[" + i + "]: " + pattern.charAt(i) + ", pi[" + (j-1) + "]: " + pi[j-1]  );
				j = pi[j-1];
				System.out.println("getPi #3: j: " + j + ", i: " + i);
			}
			
			System.out.println("getPi #4: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", P[" + i + "]: " + pattern.charAt(i) );
			
			if( pattern.charAt(i) == pattern.charAt(j) ) {
				pi[i] = ++j;
				printPi(pi);
			}						
			
			System.out.println();
		}
		
		return pi;		
	}
	
	
	private static List<Integer> kmp( String target, String pattern ) {
		
		int [] pi = getPi(pattern);
		printPi(pi);
		
		int targetLen = target.length();
		int patternLen = pattern.length();		
		List<Integer> answerList = new ArrayList<Integer> ();
		
		int j = 0;
				
		
		for( int i = 1; i < targetLen; ++i ) {
			printString("target: ", target);
			printString("pattern: ", pattern);
			
			System.out.println("kmp #1: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", T[" + i + "]: " + target.charAt(i) );
			while( j > 0 && target.charAt(i) != pattern.charAt(j) ) {
				
				System.out.println("kmp #2: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", T[" + i + "]: " + target.charAt(i) + ", pi[" + (j-1) + "]: " + pi[j-1] );
				j = pi[j-1];				
				System.out.println("kmp #3: j: " + j + ", i: " + i );				
			}
			
			System.out.println("kmp #1: j: " + j + ", i: " + i + ", P[" + j + "]: " + pattern.charAt(j) + ", T[" + i + "]: " + target.charAt(i) );
			
			if( target.charAt(i) == pattern.charAt(j) ) {
				if( j == patternLen-1 ) {
					System.out.println("kmp #5: j: " + j + ", i: " + i + ", addedItem: " + (i-patternLen+1) + ", pi[" + j + "]: " + pi[j] );
					answerList.add(i-patternLen+1);
					j = pi[j];					
				}
				else {
					j++;
					System.out.println("kmp #6: j: " + j + ", i: " + i );
				}
			}						
			
			System.out.println();
		}
		
		return answerList;		
	}

	private static void printPi(int [] pi ) {
		
		int tempLen = pi.length;
		int digit = 10;
		while( tempLen > 100 ) {
			digit *= 10;
			tempLen /= 10;
		}
		
		System.out.println( "Pi: " );
		for( int i = 0, len=pi.length; i < len; ++i ) {			
			System.out.print( (i%digit) + " " );
		}
		System.out.println();
		for( int k : pi ) {
			System.out.print( k + " ");
		}
		System.out.println();
	}
	
	private static void printString( String title, String str ) {
		
		int tempLen = str.length();
		int digit = 10;
		while( tempLen > 100 ) {
			digit *= 10;
			tempLen /= 10;
		}
		
		System.out.println( title );
		for( int i = 0, len=str.length(); i < len; ++i ) {			
			System.out.print( (i%digit) + " " );
		}
		System.out.println();
		for( char s : str.toCharArray() ) {
			System.out.print( s + " ");
		}
		System.out.println();
		System.out.println();
	}
	
}
