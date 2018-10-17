package kakao.newbee._2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_SecretMap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		// �迭 ����
		int [][] arr = new int[3][cnt];
		
		// �迭 �Է�
		for( int i = 0; i < 2; ++i ) {
			for( int j = 0; j < cnt; ++j ) {
				arr[i][j] = sc.nextInt();
			}			  
		}
		
		// ���� ����
		int mask = ( 1 << cnt ) - 1;					
			
		for( int j = 0; j < cnt; ++j ) {
			arr[2][j] = mask & ( arr[0][j] | arr[1][j] );
			System.out.print(arr[2][j] + " ");
		}
		System.out.println();
		
		
		
		List<String> map = new ArrayList<String>();
		
		for( int i = 0; i < cnt; ++i ) {
						
			StringBuilder sb = new StringBuilder();
			
			for( int j = 0; j < cnt; ++j ) {
				mask = 1 << (cnt-j-1);
				System.out.println("mask: " + mask + ", result: " + (arr[2][i] & mask) + ", target: " + arr[2][i] );
				
				if( (arr[2][i] & mask) > 0 ) {
					sb.append("#");
				}
				else {
					sb.append(" ");
				}
			}
			
			map.add(sb.toString());
		}
		
		for( String curMap : map ) {
			System.out.print(curMap + ", ");
		}	
		
		System.out.println();
	}
}
