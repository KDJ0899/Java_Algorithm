package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : OperatorEmbedding.java
  * @Project : Algorithm
  * @Date : 2020. 10. 9. 
  * @Author : Kim DongJin
  * @Comment : 백준 14888번 연산자 끼워넣기 문제 풀이 완료.
 */
public class OperatorEmbedding {
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		int plus,  minus, multi, div;
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		plus = sc.nextInt();
		minus = sc.nextInt();
		multi = sc.nextInt();
		div = sc.nextInt();
		
		calculate(numbers, 1, numbers[0], plus, minus, multi, div);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calculate(int[] numbers, int index, int sum, int plus, int minus, int multi, int div) {
		
		if (index>=numbers.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(plus > 0)
			calculate(numbers, index+1, sum + numbers[index], plus-1, minus, multi, div);
		if(minus > 0)
			calculate(numbers, index+1, sum - numbers[index], plus, minus-1, multi, div);
		if(multi > 0)
			calculate(numbers, index+1, sum * numbers[index], plus, minus, multi-1, div);
		if(div > 0)
			calculate(numbers, index+1, sum / numbers[index], plus, minus, multi, div-1);
	}

}
