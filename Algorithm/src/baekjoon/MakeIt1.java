package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : MakeIt1.java
  * @Project : Algorithm
  * @Date : 2020. 3. 23. 
  * @Author : Kim DongJin
  * @Comment : 백준 1463번 1로 만들기 문제 풀이 완료.
 */
public class MakeIt1 {
	
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] memory = new int[N+1];
		System.out.println(caculate(N, memory));
		sc.close();
		
	}
	
	public static int caculate(int N,int[] memory) {
		
		if(memory[N]!=0) return memory[N];
		if(N<1) return 10000000;
		if(N==1) return 0;
		
		return memory[N] = Math.min(1+N%2+caculate((N-N%2)/2, memory),1+N%3+caculate((N-N%3)/3, memory));
		
	}

}
