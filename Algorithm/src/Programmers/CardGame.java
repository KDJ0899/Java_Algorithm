package Programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
  * @FileName : CardGame.java
  * @Project : Algorithm
  * @Date : 2019. 12. 15. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적계획법(DP) 카드게임 문제
  * 		
 */
public class CardGame {
	

	static HashMap<String, Integer> sumMap;
	static HashMap<Integer, Integer> target;
	
	
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
	
	 public static int mySolution(int[] left, int[] right) {
	        int answer = 0;
	        
	        int[] ArrL = left.clone();
	        int[] ArrR = right.clone();
	        
	        int length = left.length;
	        int MaxL,MaxR;
	        sumMap = new HashMap<String, Integer>();
	        target = new HashMap<Integer, Integer>();
	        
	        Arrays.sort(ArrL);
	     
	        Arrays.sort(ArrR);
	        
	        MaxL = ArrL[length-1];
	        MaxR = ArrR[length-1];
	        
	        if(MaxL>MaxR) {
	        	for(int i=0; i<length; i++) {
	        		answer+= right[i];
	        	}
	        }
	        else {
	        	answer=game(left, right, 0, 0, 0);
	        }
	        
	        
	        
	        return answer;
	    }
	 
	 public static int game(int[] left,int[] right,int indexL,int indexR,int sum ) {
		 
		
		 if(indexL==left.length)
			 return sum;
		 
		 if(indexR == right.length) {
			 return sum;
		 }
		 
		 int startL = indexL,startR = indexR;
		 
		 if(target.containsKey(startL)&&startR>target.get(startL)) {
			 return sumMap.get(startL+" "+target.get(startL));
		 }
		 
		 
		 while(left[indexL]>right[indexR]){
			 
			 sum += right[indexR];
			 
			 indexR++;
			 
			 if(indexR==right.length) {
				 sumMap.put(startL+" "+startR, sum);			 
				 target.put(startL, startR);
				
				 return sum;
			 }
			 
		 }
		 
		 return Math.max( game(left, right, indexL+1, indexR+1, sum), game(left, right, indexL+1, indexR, sum));
	 }

	public static void main(String[] args) {
		

		

	}

}
