package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : BinarySpecailNumber.java
  * @Project : Algorithm
  * @Date : 2020. 10. 20. 
  * @Author : Kim DongJin
  * @Comment : 백준 2579번 계단 오르기 문제 풀이.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1];
        
        if(n>1)
            dp[2] = stair[2] + stair[1];
        
        if(n>2)
            dp[3] = Math.max(dp[0] + stair[2]+stair[3] , dp[1] + stair[3]);

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
        }

        System.out.println(dp[n]);

        sc.close();

    }
}