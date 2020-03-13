package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : WineTasting.java
  * @Project : Algorithm
  * @Date : 2020. 3. 13. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 와인 시식 문제 풀이 완료.
 */
public class WineTasting {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wines = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			wines[i] = sc.nextInt();
		}
		if(n==1) 
			System.out.println(wines[1]);
		else {
			dp[1] = wines[1];
			dp[2] = wines[2]+dp[1];
			
			for(int i=3; i<wines.length; i++) {
				dp[i] = Math.max(Math.max(dp[i-1],dp[i-2]+wines[i]), dp[i-3]+wines[i-1]+wines[i]);
			}
			
			System.out.println(dp[n]);
		}
		sc.close();
	}
	

}
