package kakao.newbee._2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_ShuttleBus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int interval = sc.nextInt();
		int maxCrewCntPerShuttle = sc.nextInt();
		String timeTable = sc.nextLine();
		
		Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2})*");
		Matcher matcher = pattern.matcher(timeTable);
				
		List<Integer> timeTableList = new ArrayList<Integer>();
		while (matcher.find()) {
			int curTimeTable = Integer.parseInt(matcher.group(1)) * 60 + Integer.parseInt(matcher.group(2));
			timeTableList.add(curTimeTable);
		}
		Collections.sort(timeTableList);
		
		int crewCntOnAllShuttle = 0;
		int crewCntOnLastShuttle = 0;
		int lastShuttleTime = 540;
		
		for( int i = 0; i < cnt; ++i ) {
			lastShuttleTime = 540 + ( i * interval );
			crewCntOnLastShuttle = 0;
			//System.out.println("lastShuttleTime: " + lastShuttleTime);
			for( int j = 0; j < maxCrewCntPerShuttle && crewCntOnAllShuttle < timeTableList.size(); ++j ) {
				if( lastShuttleTime >= timeTableList.get(crewCntOnAllShuttle) && crewCntOnAllShuttle < maxCrewCntPerShuttle * (i+1) ) {
					//System.out.println(timeTableList.get(crewCntOnAllShuttle) + " got on the bus.");
					crewCntOnAllShuttle++;	
					crewCntOnLastShuttle++;
				}
			}
		}

/*		
		System.out.println("lastShuttleTime: " + lastShuttleTime);
		System.out.println("lastCrewIndex: " + (crewCntOnAllShuttle-1) );
		System.out.println("lastCrewCntOnShuttle: " + (crewCntOnLastShuttle) );
*/		
		int answer = 0;
		// ������ ������ �� ź ���(�������� ź ������� 1�� ���� �����ؾ� ��)
		if( crewCntOnLastShuttle == maxCrewCntPerShuttle ) {
			answer = timeTableList.get(crewCntOnAllShuttle-1)-1;
		}
		// ������ �ڸ��� ���� ��� (������ ��Ʋ ��� �ð��� ��)
		else {
			answer = lastShuttleTime;
		}
		
		System.out.println(String.format("%02d:%02d", answer/60, answer%60));
	}
}
