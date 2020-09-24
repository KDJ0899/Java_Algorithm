package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : Move.java
  * @Project : Algorithm
  * @Date : 2020. 9. 24. 
  * @Author : Kim DongJin
  * @Comment : 백준 11048 이동하기 문제 풀이 완료
 */
public class Move {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] maze = new int[n][m], dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = maze[0][0];
		
		for(int j=1; j<m; j++) {
			dp[0][j] = dp[0][j-1] + maze[0][j];
		}
		
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0] + maze[i][0];
			
			for(int j=1; j<m; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + maze[i][j];
			}
			
		}
		
		System.out.println(dp[n-1][m-1]);
	}

}
