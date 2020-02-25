package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @FileName : Arithmetic.java
 * @Project : Algorithm
 * @Date : 2020. 2. 24.
 * @Author : Kim DongJin
 * @Comment : 프로그래머스 사칙연산 문제 풀이
 */
public class Arithmetic {
	static int[][] dp;

	public static int solution(String arr[]) {
		int answer = 1;
		int N = arr.length;

		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
			if (i % 2 == 0) {
				dp[i][i] = Integer.parseInt(arr[i]);

			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		answer = solve(arr, 0, N - 1);
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		return answer;
	}

	public static int solve(String[] arr, int a, int b) {
		System.out.println(a+"   "+b);
		 
		if (dp[a][b] != Integer.MIN_VALUE) {
			return dp[a][b];
		}

		if (a - 1 >= 1 && arr[a - 1].equals("-")) {
			int result = Integer.MAX_VALUE;
			for (int i = a; i < b; i += 2) {
				if (arr[i + 1].equals("-")) {
					result = Math.min(result, solve(arr, a, i) - solve(arr, i + 2, b));
				} else {
					result = Math.min(result, solve(arr, a, i) + solve(arr, i + 2, b));
				}
			}
			dp[a][b] = result;
		} else {
			int result = Integer.MIN_VALUE;
			for (int i = a; i < b; i += 2) {
				if (arr[i + 1].equals("-")) {
					result = Math.max(result, solve(arr, a, i) - solve(arr, i + 2, b));
				} else {
					result = Math.max(result, solve(arr, a, i) + solve(arr, i + 2, b));
				}
			}
			dp[a][b] = result;
		}
		System.out.println(dp[a][b]);
		return dp[a][b];
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "1", "-", "3", "+", "5", "-", "8" }));
//		System.out.println(solution(new String[] { "4", "+", "5", "+", "6", "-", "5", "+", "4", "+", "2", "+", "1", "-",
//				"5", "+", "6", "+", "7", "-", "8", "-", "4" }));
//		System.out.println(solution(new String[] { "4", "+", "5", "+", "6", "+", "5", "+", "4", "+", "2", "+", "1", "+",
//				"5", "+", "6", "+", "7", "+", "8", "+", "4" }));
		List<Integer> list = new ArrayList<Integer>();

	}

}
