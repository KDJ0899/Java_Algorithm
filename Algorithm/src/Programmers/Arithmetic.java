package Programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
  * @FileName : Arithmetic.java
  * @Project : Algorithm
  * @Date : 2020. 2. 24. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 사칙연산 문제 풀이 (정확성 통과)
 */
public class Arithmetic {
	static int answer = Integer.MIN_VALUE;
	public static int solution(String arr[]) {
		
		List<String> operators = new ArrayList<String>();
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length/2; i++) {
			numbers.add(Integer.parseInt(arr[i*2]));
			operators.add(arr[i*2+1]);
		}
		
		numbers.add(Integer.parseInt(arr[arr.length-1]));
		
		for(int i=0; i<operators.size(); i++) {
			calculate(operators, numbers, i);
		}
		
		return answer;
	}
	
	public static void calculate(List<String> operators, List<Integer> numbers,int index) {
		
		System.out.println(operators.toString());
        System.out.println(numbers.toString());
        
		int result;
		List<String> newOperators = new ArrayList<String>();
		newOperators.addAll(operators);
		
		List<Integer> newNumbers = new ArrayList<Integer>();
		newNumbers.addAll(numbers);
		
		if(operators.get(index).equals("+")) {
			result=numbers.get(index)+numbers.get(index+1);
		}
		else{
			result=numbers.get(index)-numbers.get(index+1);
		}
		
		newNumbers.set(index, result);
		newNumbers.remove(index+1);
		newOperators.remove(index);
			
		for(int i=0; i<newOperators.size(); i++) {
			calculate(newOperators, newNumbers, i);
		}
		
		if(newOperators.size()==0) {
			System.out.println(newNumbers.get(0));
			answer = Math.max(newNumbers.get(0), answer);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
		List<Integer> list = new ArrayList<Integer>();
		

	}

}
