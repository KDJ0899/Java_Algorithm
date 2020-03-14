package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : TheaterSeats.java
  * @Project : Algorithm
  * @Date : 2020. 3. 14. 
  * @Author : Kim DongJin
  * @Comment :백준 DP 2302 극장 좌석 문제 풀이 완료.
 */
public class TheaterSeats {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc. nextInt();
		int M = sc. nextInt();
		int[] seats = new int[N+1];
		int[] ranges = new int[M+2];
		int[] answers = new int[M+1];
		int answer = 1;
		
		for(int i=1; i<M+1; i++) {
			ranges[i] = sc.nextInt();
		}
		
		if(N==1)
			System.out.println(1);
		else {
			ranges[M+1] = N+1;
			
			seats[0] = 1;
			seats[1] = 2;
		
			for(int i = 1; i < M+2; i++) {
				answers[i-1] = dp(ranges[i]-ranges[i-1]-1,seats);
			}
			
			for(int i=0; i<answers.length; i++) {
				answer *= answers[i];
			}
			
			System.out.println(answer);
			sc.close();
		}
	}
	
	public static int dp (int i, int[] seats) {
		if(i==1)
			return 1;
		else if(i==2)
			return 2;
		
		if(seats[i]!=0)
			return seats[i];
		
		return seats[i] = dp(i-1,seats)+dp(i-2,seats);
	}

}
