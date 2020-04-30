package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : NoStairs.java
  * @Project : Algorithm
  * @Date : 2020. 4. 30. 
  * @Author : Kim DongJin
  * @Comment : 백준 알고리즘 1562번 계단수 문제 풀이
 */
public class NoStairs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] stairs = new int[10], newStairs;
		int answer = 0;
		for(int i=0; i<stairs.length; i++)
			stairs[i] = 1;
		
		int N = sc.nextInt();
		
		for(int i=1; i<N; i++) {
			newStairs = new int[10];
			
			newStairs[0] = stairs[1];
			
			for(int j = 1; j<8; j++) {
				newStairs[j] = stairs[j-1]+stairs[j+1];
			}
			newStairs[9] = stairs[8];
			
			stairs = newStairs.clone();
		}
		
		for(int i=0; i<stairs.length; i++)
			answer= (answer + stairs[i])%1000000000;
		
		System.out.println(answer);
	}

}
