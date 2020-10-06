package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
  * @FileName : TreeTraversal.java
  * @Project : Algorithm
  * @Date : 2020. 10. 6. 
  * @Author : Kim DongJin
  * @Comment : 백준 1991 트리 순회 문제 풀이 완료.
 */
public class TreeTraversal {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()), index;
		int[][] tree = new int[n][2];
		char[] words;
		for(int i=0; i<n; i++) {
			words = br.readLine().replaceAll(" ", "").toCharArray();
			
			index = words[0]%65;
			if(words[1] == '.') 
				tree[index][0] = -1;
			else
				tree[index][0] = words[1]%65;
			
			if(words[2] == '.') 
				tree[index][1] = -1;
			else
				tree[index][1] = words[2]%65;
		}
		preOrder(tree, 0);
		System.out.println();
		inOrder(tree, 0);
		System.out.println();
		postOrder(tree, 0);
	}
	
	public static void preOrder(int[][] tree, int index) {
		System.out.print((char)(index+65));
		if(tree[index][0] != -1) preOrder(tree, tree[index][0]);
		if(tree[index][1] != -1) preOrder(tree, tree[index][1]);
	}
	public static void inOrder(int[][] tree, int index) {
		if(tree[index][0] != -1) inOrder(tree, tree[index][0]);
		System.out.print((char)(index+65));
		if(tree[index][1] != -1) inOrder(tree, tree[index][1]);
	}
	public static void postOrder(int[][] tree, int index) {
		if(tree[index][0] != -1) postOrder(tree, tree[index][0]);
		if(tree[index][1] != -1) postOrder(tree, tree[index][1]);
		System.out.print((char)(index+65));
	}
	

}
