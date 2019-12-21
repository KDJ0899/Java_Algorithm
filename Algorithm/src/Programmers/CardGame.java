package Programmers;
/**
 * 
  * @FileName : CardGame.java
  * @Project : Algorithm
  * @Date : 2019. 12. 15. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적계획법(DP) 카드게임 문제
  * 		아직 DP 많이 미숙함.
 */
public class CardGame {
	
	public static int solution(int[] left, int[] right)
    {
        int[][] dp = new int[left.length+1][right.length+1];

        for(int i = 1; i <= left.length; i++)
        {
            for(int j = 1; j <= right.length; j++)
            {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                if(right[j-1] < left[i-1])
                {
                    dp[i][j] = dp[i][j-1] + right[j-1];
                }
            }
        }

        return dp[left.length][right.length];
    }

	public static void main(String[] args) {
		

		

	}

}
