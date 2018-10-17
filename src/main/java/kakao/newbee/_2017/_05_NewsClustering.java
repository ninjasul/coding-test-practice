package kakao.newbee._2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_NewsClustering {
	
	private static int unionCnt = 0;
	private static int intersectionCnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String [] tokens = input.toUpperCase().split("\t");
		List<String> [] strListArray = (List<String>[])new ArrayList[tokens.length]; 
		
		for( int i = 0; i < strListArray.length; ++i ) {
			strListArray[i] = new ArrayList<String>();
		}
		
		for( int i = 0; i < tokens.length; ++i ) {
			String curToken = tokens[i];
			System.out.println( "curToken: " + curToken );
			
			for( int j = 0; j < curToken.length()-1; j++ ) {
				String curElement = curToken.substring(j, j+2);
								
				System.out.println("curElement: "  + curElement);
				if( curElement.matches("([a-zA-Z]{2})")) {
					System.out.println("setElement: "  + curElement);
					strListArray[i].add(curElement);
				}
			}
		}
		
		
		
		for( List<String> curList : strListArray ) {
			
			//Collections.sort(curList);
			
			System.out.println("************* Set ****************");
			for( String curStr : curList ) {
				System.out.println(curStr);
			}
			System.out.println("**********************************");
		}
		
		if( strListArray.length >= 2 ) {			
			
			Set<String> primarySet = new HashSet<String>();
			primarySet.addAll(strListArray[0]);
			primarySet.addAll(strListArray[1]);			
			
			for( String curStr : primarySet ) {
				System.out.println(curStr);
			}
			
			getUnionAndIntersectionCnt( primarySet, strListArray );
			
			System.out.println("unionCnt: " + unionCnt );
			System.out.println("intersectionCnt: " + intersectionCnt );
			
			if( strListArray[0].size() > 0 && strListArray[1].size() > 0 ) {
				System.out.println((int)((double)intersectionCnt/unionCnt*65536));
			}
			else {
				System.out.println(65536);
			}
		}
		else {
			System.out.println(0);
		}
/*		for( String curToken : tokens ) {
			System.out.println(curToken);
		}
*/		

		
	}	
	
	static private void getUnionAndIntersectionCnt( Set<String> primarySet, List<String> [] strListArray ) {

		final List<String> primaryList = new ArrayList<String>(primarySet);
		//Collections.sort(primaryList);
		
		final int primaryListSize = primaryList.size();
		
		for (int x = 0; x < primaryListSize; x++) {
		    final String curStr = primaryList.get(x);		   
		    final int aFrequency = Collections.frequency(strListArray[0],  curStr);
		    final int bFrequency = Collections.frequency(strListArray[1],  curStr);
		    
		    intersectionCnt += Math.min(aFrequency, bFrequency);
		    unionCnt += Math.max(aFrequency, bFrequency);
		}
	}
}
