package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : SteppingStones.java
  * @Project : Algorithm
  * @Date : 2020. 4. 2. 
  * @Author : Kim DongJin
  * @Comment : 백준 11561 징검다리 문제 풀이
 */
public class SteppingStones {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), sqrt, maxIndex = 0;
		int[] jump;
		long max = 0;
		long[] N = new long[T];
		
		for(int i=0; i<T; i++) {
			N[i] = sc.nextLong();
			
			if(max < N[i]) {
				max = N[i];
				maxIndex = i;
			}
		}
		jump = new int[750000000];
		int index = 1;
		while(true) {
			jump[index] = jump[index-1] + index;
			
			if(max <jump[index]) {
				N[maxIndex] = index-1;
				break;
			}
			index++;
		}
		
		for(int i=0; i<T; i++) {
			if(maxIndex != i) {
				System.out.println(search(jump, N[i], (int)Math.sqrt(N[i])));
			}
			else System.out.println(N[i]);
		}
	}
	
	public static int search(int[] jump, long n, int index) {
		if(jump[index] == n) return index;
		if(jump[index] == 0) {
			int gap = (int) ((jump[index] - n)/index);
			gap = gap == 0? 1 : gap;
			return search(jump, n, index - gap );
		}
		else if(jump[index]>n) {
			if(jump[index-1]<n) return index-1;
			int gap = (int) ((jump[index] - n)/index);
			gap = gap == 0? 1 : gap;
			return search(jump, n, index - gap );
		}
		else {
			int gap = (int) ((n - jump[index])/index);
			gap = gap == 0? 1 : gap;
			return search(jump, n, index + gap );
		}
	}
	

}
