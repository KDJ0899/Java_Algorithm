package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : Coin.java
  * @Project : Algorithm
  * @Date : 2020. 9. 23. 
  * @Author : Kim DongJin
  * @Comment : 백준 9084번 동전 문제 풀이 완료.
 */
public class Coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int coins[] = new int[n + 1];
			for (int i = 1; i <= n; i++)
				coins[i] = sc.nextInt();

			int money = sc.nextInt();
			int dp[] = new int[money + 1];

			dp[0] = 1;
			for (int i = 1; i <= n; i++)
				for (int j = coins[i]; j <= money; j++)
					dp[j] += dp[j - coins[i]];
			System.out.println(dp[money]);
		}
		sc.close();

	}
}
