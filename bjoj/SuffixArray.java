package bjoj;
import java.util.Scanner;

public class SuffixArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int [] sa = getSuffixArray(input);
	}
	
	/*private static boolean compare( int x, int y, int t ) {
		return( )
	}*/
	
	private static int[] getSuffixArray(String str) {
		
		if( str == null || str.length() <= 0 ) return null;
		int strLen = str.length();
		int [] group = new int[strLen+1];
		int [] tempGroup = new int[strLen+1];
		int [] sa = new int[strLen];
		
		for( int i = 0; i < strLen; ++i ) {
			sa[i] = i;
			group[i] = str.charAt(i) - 'a';
			System.out.println("group[" + i + "]: " + group[i]);
		}
		
		int t = 1;
		while (t <= strLen) {    // 1,2,4,8... 씩 단어의 길이보다 작은 경우를 탐색
	        group[strLen] = -1;
	        
	        // 그룹에 의한 정렬
	        //Arrays.sort( group, 0, strLen );
	        
	        for( int i = 0; i < strLen; ++i ) {
				System.out.println("group[" + i + "]: " + group[i]);
			}
	        
	        // 다음 그룹을 할당하기 위하여 tempgroup의 첫번째 번호 배정
	        tempGroup[sa[0]] = 0;
	        
            // 다음 그룹 배정
	        for ( int i = 1; i < strLen; i++ ) {    

	        	// 그룹이 다를 경우 다음 그룹 번호 할당
	            if ( compare( group, sa[i-1], sa[i], t ) ) 
	                tempGroup[sa[i]] = tempGroup[sa[i-1]] + 1;
	            // 그룹이 같을 경우 같은 그룹 번호 할당
	            else      
	                tempGroup[sa[i]] = tempGroup[sa[i-1]];
	        }
	        
	        for( int i = 0; i < strLen; ++i ) {
				System.out.println("tempGroup[" + i + "]: " + tempGroup[i]);
			}
	        
   	        // 새로운 그룹 할당
	        for (int i = 0; i < strLen; i++)
	            group[i] = tempGroup[i];    
	        
	        t <<= 1;    
	    }
		
		return sa;
		
		
		/*t = 1;
		
	    int n = (int)strlen(str);    //글자의 수 배정
	    for (int i = 0; i < n; i++) {        
	        SA[i] = i;
	        g[i] = str[i] - 'a';
	    }        //첫 글자에 의한 그룹을 정해주는 전처리
	    
	    while (t <= n) {    // 1,2,4,8... 씩 단어의 길이보다 작은 경우를 탐색
	        g[n] = -1;
	        sort(SA, SA + n, cmp);    //그룹에 의한 정렬
	        tg[SA[0]] = 0;//다음 그룹을 할당하기 위하여 tempgroup의 첫번째 번호 배정
	        
	        for ( int i = 1; i < n; i++ ) {    //다음 그룹 배정 
	            if (cmp(SA[i - 1], SA[i])) //그룹이 다를 경우 다음 그룹 번호 할당
	                tg[SA[i]] = tg[SA[i - 1]] + 1;
	            else      //그룹이 같을 경우 같은 그룹 번호 할당
	                tg[SA[i]] = tg[SA[i - 1]];
	        }
	        
	        for (int i = 0; i < n; i++)
	            g[i] = tg[i];    //새로운 그룹 할당
	        
	        t <<= 1;    
	    }*/
		
		
	}
	
	private static boolean compare( int [] array, int x, int y, int t ) {
		 if (array[x] == array[y]) {
		        return array[x + t] < array[y + t];
		 }
		 
		 return array[x] < array[y];
	}
}
