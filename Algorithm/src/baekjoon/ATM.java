package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
  * @FileName : ATM.java
  * @Project : Algorithm
  * @Date : 2020. 9. 29. 
  * @Author : Kim DongJin
  * @Comment : 백준 11399번 ATM문제 풀이 완료.
 */
public class ATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), time = 0, answer = 0;
		int[] people = new int[N];
		
		for(int i=0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		
		Arrays.sort(people);
		
		for(int i=0; i<N; i++) {
			answer += time + people[i];
			time += people[i];
		}
		
		System.out.println(answer);
	}	

}
