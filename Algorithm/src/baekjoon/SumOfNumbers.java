package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : SumOfNumbers.java
  * @Project : Algorithm
  * @Date : 2020. 5. 25. 
  * @Author : Kim DongJin
  * @Comment : 백준 알고리즘 2003번 수들의 합 2 문제 풀이 완료 (투 포인터)
 */
public class SumOfNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0, sum = 0, start = 0;
		int[] numbers = new int[N];
		
		
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
			sum += numbers[i];
			
			while(sum>M) {
				if(start>=N)
					break;
				
				sum -= numbers[start];
				start++;
			}
			
			if(sum == M)
				answer++;
		}
		
		System.out.println(answer);

	}

}
