package bjoj._01.basic.ds;

import java.util.Scanner;
import java.util.Stack;

public class _10828_Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int cmdsLength = sc.nextInt();
		sc.nextLine();
		
		Stack<Integer> stack = new Stack<>();
		
		for( int i = 0; i < cmdsLength; ++i ) {
			
			String [] cmds = sc.nextLine().split(" ");
			
			if( cmds[0].equalsIgnoreCase("push") ) {
				stack.push(Integer.parseInt(cmds[1]));
			}
			else if( cmds[0].equalsIgnoreCase("pop") ) {
				if( stack.size() > 0 ) {
					System.out.println(stack.pop());
				}
				else {
					System.out.println(-1);
				}
			}
			else if( cmds[0].equalsIgnoreCase("size") ) {
				System.out.println(stack.size());
			}
			else if( cmds[0].equalsIgnoreCase("empty") ) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			}
			else if( cmds[0].equalsIgnoreCase("top") ) {
				if( stack.size() > 0 ) {
					System.out.println(stack.peek());
				}
				else {
					System.out.println(-1);
				}				
			}
		}
	}
}
