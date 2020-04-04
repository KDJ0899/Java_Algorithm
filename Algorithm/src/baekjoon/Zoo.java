package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : Zoo.java
  * @Project : Algorithm
  * @Date : 2020. 4. 4. 
  * @Author : Kim DongJin
  * @Comment :백준 1309 동물원 문제 풀이 완료.
 */
public class Zoo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][3];
		dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
		
		for (int i = 2; i <= n; i++) { 
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901; 
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2] % 9901; 
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1] % 9901; 
			}
		
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2])%9901);

	}

}
