package kakao.newbee._2017;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_Dart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		Pattern pattern = Pattern.compile("([\\d]+)([SDT])([*#]?)");
		Matcher matcher = pattern.matcher(input);
		
		String [][] tokens = new String[3][3];		
		int curCmdIndex = 0;
		
		while (matcher.find()) {

			for( int i = 1 ; i <= matcher.groupCount(); ++i ) {
				tokens[curCmdIndex][i-1] = matcher.group(i);
			}
			
            curCmdIndex++;
		}
		
		int [] temp = new int[3];
		for( int i = 0; i < 3; ++i ) {
			
			int score = Integer.parseInt(tokens[i][0]);
			
			if( "S".equals(tokens[i][1])) {
				temp[i] = score;
			}
			else if( "D".equals(tokens[i][1])) {
				temp[i] = score * score;
			}
			else if( "T".equals(tokens[i][1])) {
				temp[i] = score * score * score;
			}
			
			if( "*".equals(tokens[i][2]) ) {
				
				temp[i] *= 2;

				if( i > 0 ) {
					temp[i-1] *= 2;
				}
			}
			else if( "#".equals(tokens[i][2])) {
				temp[i] *= (-1);
			}
			
		}

		int answer = 0;
		for( int i = 0; i < temp.length; ++i ) {
			answer += temp[i];
		}
		System.out.println(answer);
	}
}
