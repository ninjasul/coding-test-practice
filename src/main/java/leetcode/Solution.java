package leetcode;
import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {


    static String timeConversion(String s) {
        // Complete this function
        if( s.endsWith("AM") ) {
            int hour = Integer.parseInt(s.substring(0,2));
            return String.format("%02d",hour%12) + s.substring(2,8);
        }
        else {
        	int hour = Integer.parseInt(s.substring(0,2));
        	
        	if( hour < 12 ) {
        		hour = (hour + 12)%24;
        	}
            return String.format("%02d", hour) + s.substring(2,8);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}