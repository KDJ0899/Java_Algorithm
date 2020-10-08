package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : App.java
 * @Project : Algorithm
 * @Date : 2020. 10. 8.
 * @Author : Kim DongJin
 * @Comment :백준 7579번 앱 문제 풀이
 */
public class App {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 10000;
		int cost, memory;

		int[] memories = new int[N];
		int[] costs = new int[N];
		int[][] dp = new int[N][100001];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st1.nextToken());
			costs[i] = Integer.parseInt(st2.nextToken());
		}

		for (int i = 0; i < N; i++) {
			cost = costs[i];
			memory = memories[i];

			for (int j = 0; j <= answer; j++) {

				if (i == 0) {
					if (j >= cost)
						dp[i][j] = memory;
				} else {
					if (j >= cost)
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				}
				
				if(dp[i][j] >= M) {
					answer = Math.min(answer, j);
				}
			}
		}
		
		System.out.println(answer);

	}

}
