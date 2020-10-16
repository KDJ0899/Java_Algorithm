package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : RGBRoad2.java
  * @Project : Algorithm
  * @Date : 2020. 10. 16. 
  * @Author : Kim DongJin
  * @Comment : 백준 17404 RGB거리2 문제 풀이 완료.
 */
public class RGBRoad2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), answer = 1000*1000;
        int[][] rgb = new int[n][3], dp = new int[n][3];
        for(int i=0; i<n; i++){
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }

        for(int k = 0; k < 3; k++) {
            for(int i = 0 ; i < 3; i++) {
                if(i == k) dp[0][i] = rgb[0][i];
                else dp[0][i] = 1001;
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for(int i = 0 ; i < 3; i++)
                if(i != k) answer = Math.min(answer, dp[n-1][i]);
        }
        System.out.println(answer);

        sc.close();
    }
}