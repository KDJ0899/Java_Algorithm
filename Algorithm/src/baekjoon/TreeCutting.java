package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : TreeCutting.java
  * @Project : Algorithm
  * @Date : 2020. 3. 30. 
  * @Author : Kim DongJin
  * @Comment : 백준 2805 나무자르기 문제 풀이 완료.
 */
public class TreeCutting {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		Integer[] trees = new Integer[N];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			trees[i] = sc.nextInt();
			max = Math.max(trees[i], max);
		}
		
		int left = 1; 
		int right = max; 
		int middle = (left + right) / 2; 
		
		while (left <= right) { 
			long sum = 0; 
			for (int i = 0; i < N; i++) 
				sum += Math.max(0, trees[i] - middle); 
			if (sum < M) right = middle - 1; 
			else left = middle + 1; middle = (left + right) / 2; 
			}
		
		System.out.println(right);
	}

}
