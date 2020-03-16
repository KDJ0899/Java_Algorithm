package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : TravelingSalespersonProblem.java
  * @Project : Algorithm
  * @Date : 2020. 3. 16. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 외판원 순회 문제 풀이 완료. (TSP문제) 비트마스킹
 */
public class TravelingSalespersonProblem {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int finish = (1<<N)-1;
		int[][] dp = new int[N][1<<N];
		int visited = 1;
		
		int[][] travelCost = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				travelCost[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(travel(travelCost, 0, visited, finish,dp));
		
	}
	
	public static int travel(int[][] travelCost, int i, int visited,int finish, int[][] dp) {
		
		if(dp[i][visited]!=0)
			return dp[i][visited];
		
		if(finish==visited) {
			if(travelCost[i][0]==0) return 10000000;
			return travelCost[i][0];
		}
			
		dp[i][visited]=10000000;
		
		for(int j=1; j<travelCost.length; j++) {
			if((visited&(1<<j))==0 && travelCost[i][j]!=0) {
				dp[i][visited] = Math.min(dp[i][visited],travelCost[i][j]+travel(travelCost, j, (visited|(1<<j)) ,finish,dp));
			}
		}
		return dp[i][visited];
	}

}
