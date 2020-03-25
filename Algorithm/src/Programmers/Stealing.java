/**
 * 
 */
package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : Stealing.java
  * @Project : Algorithm
  * @Date : 2020. 3. 25. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 동적계획법 도둑질 문제 풀이 완료.
 */
public class Stealing {
	public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 6, 5, 1, 3 ,2 ,5, 4, 8, 2,3,5,4,6,7,3,2,1,34,2,1,1,2,3,6,7,23,5,543,6,7,4,12,21,3,4,3,634,6,7,457,45,8}));
        System.out.println(solution1(new int[] {1, 6, 5, 1, 3 ,2 ,5, 4, 8, 2,3,5,4,6,7,3,2,1,34,2,1,1,2,3,6,7,23,5,543,6,7,4,12,21,3,4,3,634,6,7,457,45,8}));
		
	}
	
	public static int solution(int[] money) {
		int length = money.length;
        boolean[] security = new boolean[length];
        money[2]+= money[0];
        security[0] = true;
        security[2] =true;
        for(int i=3; i<length-1; i++) {
        	
        	if(money[i-3]>money[i-2]) {
        		money[i]+= money[i-3];
        		security[i]=security[i-3];
        	}
        	else if(money[i-3]<money[i-2]) {
        		money[i]+=money[i-2];
        		security[i]=security[i-2];
        	}
        	else {
        		money[i]+=money[i-2];
        		if(!(security[i-3]&&security[i-2]))
        			security[i] = false;
        		else
        			security[i] = true;
        	}
        }
        if(security[length-3]) {
        	if(money[0]<money[length-1]) money[length-3] += money[length-1]-money[0];
        }
        else 
        	money[length-3]+= money[length-1];
        
        return Math.max(money[length-3], money[length-2]);
    }
	
   public static int solution1(int[] money) {
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }
        
        dp2[length-1]=Math.max(dp2[length-3]+money[length-1],dp2[length-2]);
        return Math.max(dp[length-2],dp2[length-1]);
    }
	
}
