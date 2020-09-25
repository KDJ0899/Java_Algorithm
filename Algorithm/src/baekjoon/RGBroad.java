package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : RGBroad.java
  * @Project : Algorithm
  * @Date : 2020. 9. 25. 
  * @Author : Kim DongJin
  * @Comment : 백준 1149 RGB거리 문제 풀이 완료.
 */
public class RGBroad {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), answer;
		int[][] rgb = new int[n][3];
		
		rgb[0][0] = sc.nextInt();
		rgb[0][1] = sc.nextInt();
		rgb[0][2] = sc.nextInt();
		
		for(int i=1; i<n; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();
			
			if(rgb[i-1][2]>rgb[i-1][1])
				rgb[i][0] += rgb[i-1][1];
			else
				rgb[i][0] += rgb[i-1][2];
			
			if(rgb[i-1][2] > rgb[i-1][0])
				rgb[i][1] += rgb[i-1][0];
			else
				rgb[i][1] += rgb[i-1][2];
			
			if(rgb[i-1][1] > rgb[i-1][0])
				rgb[i][2] += rgb[i-1][0];
			else
				rgb[i][2] += rgb[i-1][1];
		}
		
		answer = Math.min(rgb[n-1][0], rgb[n-1][1]);
		answer = Math.min(answer, rgb[n-1][2]);
		System.out.println(answer);
		
	}
}
