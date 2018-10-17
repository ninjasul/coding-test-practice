package bjoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _02252_lineup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfPerson = sc.nextInt();
		int numOfComparision = sc.nextInt();
		sc.nextLine();
		
		List<Integer> [] edgeList = (List<Integer>[]) new List[numOfPerson+1];
		int [] indegreeCnt = new int[numOfPerson+1];
		
		// ���� ����Ʈ ����
		for( int i = 0; i <= numOfPerson; ++i )
		{
			edgeList[i] = new ArrayList<Integer>();
		}
		
		// �� �� �����͸� ������ ���� ����Ʈ �ʱ�ȭ
		for( int i = 0; i < numOfComparision; ++i )
		{
			int startPersonIndex = sc.nextInt();
			int endPersonIndex = sc.nextInt();			
			
			edgeList[startPersonIndex].add(endPersonIndex);
			indegreeCnt[endPersonIndex]++;
		}
		
		// ���� �������� ���� 
		for( List<Integer> curEdgeList : edgeList )
			Collections.sort(curEdgeList);
		
		// �� Person ���� in-degree count �� 0�� Person�� Queue�� ����
		Queue<Integer> orderQueue = new LinkedList<Integer> ();
		for( int i = 1; i <= numOfPerson; ++i )
		{
			if( indegreeCnt[i] == 0 )
				orderQueue.add(i);
		}
		
		// Queue �� �� ������ ����
		while( orderQueue.peek() != null )
		{
			// Queue �� �� �ִ� ������� in-degree count�� ����
			int curPersonIndex = orderQueue.remove();
			System.out.print(curPersonIndex + " ");
			
			for( int curEndPersonIndex : edgeList[curPersonIndex] )
			{
				// �� ����� �Ǵ� Person�� in-degree count�� ����
				indegreeCnt[curEndPersonIndex]--;
				
				// in-degree count�� 0�� Person�� Queue �� ����
				if( indegreeCnt[curEndPersonIndex] <= 0 )
					orderQueue.add(curEndPersonIndex);
			}
		}
	}
}
