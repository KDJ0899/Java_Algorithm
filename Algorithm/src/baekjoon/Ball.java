package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : Ball.java
  * @Project : Algorithm
  * @Date : 2020. 4. 13. 
  * @Author : Kim DongJin
  * @Comment :백준 1547 공 문제 풀이 완료.
 */
public class Ball {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(), x, y, answer = -1;
		boolean[] cups = new boolean[4];
		boolean tmp;
		cups[1] = true;
		
		for(int i=0; i<M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			tmp = cups[x];
			cups[x] = cups[y];
			cups[y] = tmp;
		}
		
		for(int i=1; i<4; i++) {
			if(cups[i])
				answer = i;
		}
		System.out.println(answer);
	}

}
