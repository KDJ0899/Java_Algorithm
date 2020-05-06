package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : NoShrink.java
  * @Project : Algorithm
  * @Date : 2020. 5. 6. 
  * @Author : Kim DongJin
  * @Comment : 백준 2688번 줄어들지 않아 문제 풀이 완료.
 */
public class NoShrink {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), n, i, j;
		long d[][] = new long[65][10];
		
		for(i = 0; i < 10; i++) d[1][i] = i + 1;
		
		while (t-->0) {
			n = sc.nextInt();
			if(d[n][9]==0) {
				for (i = 2; i <= n; i++){
					d[i][0] = 1;
					
					for (j = 1; j < 10; j++)
						d[i][j] = d[i - 1][j] + d[i][j - 1];
				}
			}
			System.out.println(d[n][9]);
		}
		sc.close();


	}
}
