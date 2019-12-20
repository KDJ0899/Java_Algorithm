package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : Budget.java
  * @Project : Algorithm
  * @Date : 2019. 12. 20. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 예산 문제 풀이
 */
public class Budget {
	
	 public int solution(int[] budgets, int M) {
	        int answer = 0;
	        int sum=0,index = budgets.length-1,count=1, diff = 0, tmp;
	        
	        Arrays.sort(budgets);
	        
	        for(int i=0; i<budgets.length; i++) {
	        	sum+= budgets[i];
	        }
	        
	        if(sum<=M)
	        	return budgets[budgets.length-1];
	        
	        
	        while(true) {
	        	tmp = diff;
	        	diff += (budgets[index] - budgets[index -1]) * count;
	        	
	        	if(sum - diff <=M) {
	        		int i=1;
	        		int num = budgets[index];
	        		sum -= tmp;
	        		while (true) {
	        			if(sum - i *count <=M ) {
	        				break;
	        			}
	        		}
	        		
	        		break;
	        	}
	        	
	        }
	        
	        
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
