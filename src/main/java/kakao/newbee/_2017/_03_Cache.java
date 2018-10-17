package kakao.newbee._2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Cache {

	public static int CACHE_SIZE = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CACHE_SIZE = sc.nextInt();
		String input = sc.nextLine();
		
		Pattern pattern = Pattern.compile("(\\w+)");
		Matcher matcher = pattern.matcher(input);
		//Set<String> cache = new HashSet<String>(Arrays.asList(input.replace("[", "").replace("]", newChar).replace("\"", "").split(",")));		
		Map<String, String> cache = new LinkedHashMap<String, String>(CACHE_SIZE*4/3, 0.75f, true) {	        
	        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
	        	if( size() > CACHE_SIZE ) {
	        		remove(eldest.getKey());
	        		return true;
	        	}
	        	
	        	return false;
	        }
		};
		
		int executionTime = 0;
		while (matcher.find()) {
			String curCity = matcher.group(1);
			
			if(cache.containsKey(curCity.toUpperCase())) {
				executionTime += 1;
			}
			else {
				executionTime += 5;
				cache.put(curCity.toUpperCase(), curCity);
			}
		}
		
		System.out.println(executionTime);	
	}
}
