package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
  * @FileName : LostParenthesis.java
  * @Project : Algorithm
  * @Date : 2020. 10. 8. 
  * @Author : Kim DongJin
  * @Comment : 백준 1541번 잃어버린 괄호 문제 풀이.
 */

public class LostParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0, num = 0;
		boolean flag = false;
		String expression = sc.nextLine();
		StringBuilder number = new StringBuilder();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Character> operators = new ArrayList<Character>();
		
		for(char word : expression.toCharArray()) {
			
			if(word != '+' && word != '-') {
				number.append(word);
			}else {
				numbers.add(Integer.parseInt(number.toString())); 
				number = new StringBuilder();
				operators.add(word);
			}
		}
		
		numbers.add(Integer.parseInt(number.toString())); 
		answer = numbers.get(0);
		
		for(int i=0; i<operators.size(); i++) {
			char word = operators.get(i);
			
			if(word == '+') {
				num += numbers.get(i+1);
			} else {
				if(flag)
					answer -= num;
				else
					answer += num;
				
				flag = true;
				num = numbers.get(i+1);
			}
		}
		
		if(flag)
			answer -= num;
		else
			answer += num;
		
		System.out.println(answer);
		
	}

}
