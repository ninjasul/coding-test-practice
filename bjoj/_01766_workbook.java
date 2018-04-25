package bjoj;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _01766_workbook {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfProblem = sc.nextInt();
		int numOfComparision = sc.nextInt();
		sc.nextLine();
		
		// ���� ����Ʈ ����
		List<Integer> [] edgeList = (List<Integer>[]) new List[numOfProblem+1];
		for( int i = 1; i <= numOfProblem; ++i )
		{
			edgeList[i] = new ArrayList<Integer>();
		}

		// indegreeCnt ����
		int [] indegreeCnt = new int[numOfProblem+1];
		
		// �� �� �����͸� ������ ���� ����Ʈ �ʱ�ȭ
		for( int i = 0; i < numOfComparision; ++i )
		{
			int curProblem = sc.nextInt();
			int nextProblem = sc.nextInt();
			
			edgeList[curProblem].add(nextProblem);
			indegreeCnt[nextProblem]++;			
		}
		
		// �� ���� ���� in-degree count �� 0�� ������ Queue�� ����
		Queue<Integer> orderQueue = new PriorityQueue<Integer>();
		for( int i = 1; i <= numOfProblem; ++i )
		{
			if( indegreeCnt[i] == 0 )
				orderQueue.add(i);
		}

		// Queue �� �� ������ ����
		while( orderQueue.peek() != null )
		{
			// Queue �� �� �ִ� �켱������� in-degree count�� ����
			int curProblem = orderQueue.remove();
			System.out.print(curProblem + " ");
			
			for( int nextProblem : edgeList[curProblem] )
			{
				// ���� ������ in-degree count�� ����
				indegreeCnt[nextProblem]--;
				
				// in-degree count�� 0�� ������ Queue �� ����
				if( indegreeCnt[nextProblem] <= 0 )
					orderQueue.add(nextProblem);					
			}
		}
	}
}
