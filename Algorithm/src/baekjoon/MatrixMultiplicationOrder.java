package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : MatrixMultiplicationOrder.java
  * @Project : Algorithm
  * @Date : 2020. 10. 10. 
  * @Author : Kim DongJin
  * @Comment : 백준 11049번 행렬 곱셈 순서 문제 풀이 완료.
 */
public class MatrixMultiplicationOrder {
	static int[][] matrix , dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		matrix = new int[N][2];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		System.out.println(search(0, N-1));
	}
	
	public static int search(int x, int y) {
		int ans = Integer.MAX_VALUE;
		
		if(x == y)
			return 0;
		if(dp[x][y]!=0)
			return dp[x][y];
		
		for(int i=x; i<y; i++) {
			ans  = Math.min(ans, search(x,i)+search(i+1,y)+matrix[x][0]*matrix[i][1]*matrix[y][1]);
		}
		dp[x][y] = ans;
		
		return ans;
	}

}
