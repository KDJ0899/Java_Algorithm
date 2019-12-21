package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : Budget.java
  * @Project : Algorithm
  * @Date : 2019. 12. 20. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 예산 문제 풀이 완료
 */
public class Budget {
	
	 public static int solution(int[] budgets, int M) {
	        int answer = 0;
	        long sum=0;
	        int index = budgets.length-1,count=1, diff = 0, tmp;
	        
	        Arrays.sort(budgets);
	        
	        for(int i=0; i<budgets.length; i++) {
	        	sum+= budgets[i];
	        }
	        
	        if(sum<=M)
	        	return budgets[budgets.length-1];
	         
	        int i = 1;
	        while(true) {
	        	System.out.println(count);
	        	tmp = diff;
	        	if(index != 0)
	        		diff += (budgets[index] - budgets[index -1]) * count;

	        	if(index ==0 ||sum - diff <=M) {
	        		int num = budgets[index];
	        		sum -= tmp;
	        		
	        		while (true) {
	        			if(sum - i *count <=M ) {

	        				break;
	        			}
	        			i++;
	        		}
	        		
	        		break;
	        	}
	        	count++;
	        	index--;
	        	
	        }
	        
	        answer = budgets[index] - i;
	        
	        
	        return answer;
	    }

	public static void main(String[] args) {

		System.out.println(solution(new int[] {110,110,124,121}, 485));

	}

}
