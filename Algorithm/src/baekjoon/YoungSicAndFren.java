package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : YoungSicAndFren.java
  * @Project : Algorithm
  * @Date : 2020. 4. 29. 
  * @Author : Kim DongJin
  * @Comment : 백준 알고리즘 시뮬레이션 1592번 영식이와 친구들 문제 풀이 완료.
 */
public class YoungSicAndFren {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0, index = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] freinds = new int[N];
		freinds[0] = 1;
		
		while(freinds[index] < M) {
			
			if(freinds[index] % 2 == 1)
				index+=L;
			else 
				index+=N-L;
			
			index%=N;
			freinds[index]++;
			count++;
		}
		
		System.out.println(count);
	}

}
