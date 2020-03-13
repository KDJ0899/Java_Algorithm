package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
  * @FileName : ContinuousSum.java
  * @Project : Algorithm
  * @Date : 2020. 3. 13. 
  * @Author : Kim DongJin
  * @Comment :백준 DP 연속합 문제 풀이.
 */
public class ContinuousSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] numbers = new int[n];
		int[] copy;
		int[] dp = new int[n];
		int max = -1001,sum =0;
		
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}
		copy = numbers.clone();
		
		Arrays.sort(copy);
		if(copy[n-1]<=0)
			System.out.println(copy[n-1]);
		else {	
			for(int i=0; i<n; i++) {
				if(sum+numbers[i]<0) {
					max = Math.max(sum, max);
					sum=0;
				}
				else {
					if (numbers[i]<0) {
						max = Math.max(sum, max);
					}
					sum+=numbers[i];
				}
	
			}
		
			max = Math.max(sum, max);
			
			System.out.println(max);
		}
		sc.close();
	}

}
