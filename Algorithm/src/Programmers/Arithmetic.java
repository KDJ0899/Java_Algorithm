package Programmers;
/**
 * 
  * @FileName : Arithmetic.java
  * @Project : Algorithm
  * @Date : 2020. 2. 24. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 사칙연산 문제 풀이
 */
public class Arithmetic {
	
	public int solution(String arr[]) {
		int answer = 1;
		String[] operators = new String[arr.length/2];
		int[] numbers = new int[arr.length/2+1];
		
		for(int i=0; i<operators.length; i++) {
			numbers[i] = Integer.parseInt(arr[i*2]);
			operators[i] = arr[i*2+1];
		}
		
		numbers[numbers.length-1]=Integer.parseInt(arr[arr.length-1]);
		
		return answer;
	}
	
	public void calculate(String[] operatiors, int[] numbers,int[] anwsers) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
