package kakao_internship_2020;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
  * @FileName : Programming2.java
  * @Project : Algorithm
  * @Date : 2020. 5. 23. 
  * @Author : Kim DongJin
  * @Comment : 연산자 우선순위 변경에 따른 최대값 구하기.
 */
public class Programming2 {
	
	public static long solution(String expression) {
        long answer = 0;
        
        char[] words = expression.toCharArray();
        char word;
        StringBuilder operand = new StringBuilder();
        Queue<Character> operators = new LinkedList<Character>();
        Queue<Long> operands = new LinkedList<Long>();
        HashSet<Character> operatorSet = new HashSet<Character>();
        
        for(int i=0; i<words.length; i++) {
        	word = words[i];
        	
        	if(word == '+' || word == '*' || word == '-') {
        		operators.add(word);
        		operatorSet.add(word);
        		operands.add(Long.parseLong(operand.toString()));
        		operand.setLength(0);
        	}
        	else 
        		operand.append(word);
        	
        }
        
        operands.add(Long.parseLong(operand.toString()));
        
        for(Character op : operatorSet) {
        	answer = Math.max(answer,Math.abs(calculate(operators, operands, op)));
        }
        
        return answer;
    }
	
	public static long calculate(Queue<Character> operators,Queue<Long> operands,char priorityOp) {
		
		 Queue<Character> newOperators = new LinkedList<Character>();
	     Queue<Long> newOperands = new LinkedList<Long>();
	     Queue<Long> nowOperands = new LinkedList<Long>();
	     HashSet<Character> operatorSet = new HashSet<Character>();
	     
	     nowOperands.addAll(operands);
	     long num1 = nowOperands.poll(), num2 ,answer = 0;
	     
	     for(Character operator : operators) {
	    	 if(operator == priorityOp) {
	    		 num2 = nowOperands.poll();
	    		 
	    		num1 = operate(num1,num2,operator);
	    	 }
	    	 else {
	    		 newOperands.add(num1);
	    		 newOperators.add(operator);
	    		 operatorSet.add(operator);
	    		 num1 = nowOperands.poll();
	    	 }
	    		 
	     }
	     
	     if(newOperands.size() == 0)
	    	 return num1;
	     
	     newOperands.add(num1);
	     
	     for(Character op : operatorSet) {
	    	 answer = Math.max(answer,Math.abs(calculate(newOperators, newOperands, op)));
	     }
	     
	     return answer;
		
	}
	
	public static long operate(long num1, long num2, char op) {
		
		if(op == '+')
			return num1 + num2;
		else if( op == '-')
			return num1 - num2;
		else
			return num1 * num2;
			
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(solution("100-200*300-500+20"));
	}

}
