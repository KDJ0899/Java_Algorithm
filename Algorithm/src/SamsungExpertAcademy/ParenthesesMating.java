package SamsungExpertAcademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
  * @FileName : ParenthesesMating.java
  * @Project : Algorithm
  * @Date : 2020. 4. 7. 
  * @Author : Kim DongJin
  * @Comment : SW Expert Academy D4 괄호 짝짓기 문제 풀이 완료.
 */
public class ParenthesesMating {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer;
		Stack<Character> storage = new Stack<Character>();
		String str;
		char[] parentheses;
		char ch;
		Map<Character, Character> pair = new HashMap<Character, Character>();
		pair.put(')', '(');
		pair.put(']', '[');
		pair.put('}', '{');
		pair.put('>', '<');
		
		for(int testCase = 1; testCase<=10; testCase++) {
			sc.nextInt();
			str = sc.next();
			parentheses = str.toCharArray();
			storage = new Stack<Character>();
			answer = 1;
			
			for(int i=0; i<parentheses.length; i++) {
				ch = parentheses[i];
				if(ch == ')' || ch == ']' || ch == '}' || ch == '>') {
					if(storage.empty() || storage.pop() != pair.get(ch)) {
						answer = 0;
						break;
					}
				}
				else
					storage.push(ch);
					
			}
			if(!storage.empty())
				answer = 0;
			
			System.out.println("#"+testCase+" "+answer);
		}
		

	}

}
