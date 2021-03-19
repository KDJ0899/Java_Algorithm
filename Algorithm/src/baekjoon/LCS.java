package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] first = sc.nextLine().toCharArray();
        char[] second = sc.nextLine().toCharArray();
        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {

                if (first[i - 1] == second[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }   
            }

            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[first.length][second.length]);


        sc.close();
    }
}
