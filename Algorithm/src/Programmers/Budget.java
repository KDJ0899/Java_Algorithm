package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : Budget.java
  * @Project : Algorithm
  * @Date : 2019. 12. 20. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 예산 문제 풀이 완료
  * 		
 */
public class Budget {
	
	 public static int solution(int[] budgets, int M) {
	        int answer = 0;
	        long sum=0; // sum은 모든 예산요청 값의 합이기 때문에 int범위를 넘을 수가 있음.
	        int index = budgets.length-1, count=1, diff = 0, tmp; // index는 예산배열의 인덱스, count는 budgets.length - 1과 같음.
	        													 // diff는 sum을 M으로 맞추기 위해 빼는 값. 
	        
	        Arrays.sort(budgets);
	        
	        for(int i=0; i<budgets.length; i++) {
	        	sum+= budgets[i];
	        }
	        
	        if(sum<=M)
	        	return budgets[budgets.length-1]; // 예산요청 값의 합이 예산 총액 M을 넘지 않을 경우 가장 큰값을 반환.
	         
	        int i = 1;
	        while(true) {

	        	tmp = diff;
	        	if(index != 0)
	        		diff += (budgets[index] - budgets[index -1]) * count; // diff는 현재 index의 예산과 아래의 예산 값의 차이를 합산함.

	        	if(index ==0 ||sum - diff <=M) {
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
