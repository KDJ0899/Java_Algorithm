package Programmers;

import java.util.Stack;

/**
 * 
  * @FileName : StockPrice.java
  * @Project : Algorithm
  * @Date : 2020. 5. 13. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 주식가격 문제 풀이.
 */
public class StockPrice {
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> record = new Stack<Integer>();
        int price, index, length = prices.length;
        
        for(int i=0; i<length; i++) {
        	price = prices[i];
        	
        	if(record.size()>0) {
        		while(prices[record.peek()] > price) {
        			index = record.pop();
        			
        			answer[index] = i - index;
        			
        			if(record.size()==0)
        				break;
        		}
        	}
        	
        	record.add(i);
        }
        
        for(Integer i : record) {
        	answer[i] = length - i -1;
        }
        
        return answer;
    }

}
