package bjoj;

import java.util.Scanner;

public class TreeTraverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int [] treeArray = new int [size+1];
		for( int i = 1; i <= size; ++i ) {
			treeArray[i] = i;
			System.out.print(treeArray[i] + " ");
		}
		System.out.println();
		
		traverseTree( treeArray );
	}
	
	private static void traverseTree( int [] tree ) {
		
		System.out.println();
		
		int heightSize = 1;
		
		for( int i = 1, length = tree.length; i < length; i += heightSize ) {

			int curHeight = getTreeHeight(i);
			heightSize = getHeightSize(curHeight);		
			
			System.out.println("i : " + i + ", curHeight: " + curHeight + " heightSize: " + heightSize );
			
			for( int j = 0; j < heightSize && i+j < length; ++j ) {
				System.out.print(tree[i+j] + " ");
			}			
			System.out.println();
			System.out.println();
		}
	}
	
	private static int getHeightSize( int height ) {
		return (int)(Math.pow(2, height)); 
	}
	
	private static int getTreeHeight( int index ) {
		return (int)(Math.log(index) / Math.log(2)); 
	}
}
