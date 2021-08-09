package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2293번 코인1 문제 풀이 완료
 */
public class Coin1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = str.split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        int[] coins = new int[n+1];
        int[] dp = new int[k+1];

        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[coins[0]] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        System.out.println(dp[k]);
    

    }
}
