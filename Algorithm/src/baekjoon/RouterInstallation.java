package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
  * @FileName : RouterInstallation.java
  * @Project : Algorithm
  * @Date : 2020. 9. 26. 
  * @Author : Kim DongJin
  * @Comment : 백준 2110번 공유기 설치 문제 풀이 완료.
 */
public class RouterInstallation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), C = sc.nextInt(), start, end, mid, answer = 0;
		int[] houses = new int[N];
		
		for(int i=0; i<N; i++) {
			houses[i] = sc.nextInt();
		}
		
		Arrays.sort(houses);
		
		start = 1;
		end = houses[N-1] - houses[0];
		
		while(start<=end){
			mid = (start + end)/2;
			
			if(check(houses, mid, C)) {
				start = mid + 1;
				answer = Math.max(answer, mid);
			}else {
				end = mid -1;
			}
			
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(int[] houses, int dis, int C) {
		int count = 1, checkPoint = houses[0] + dis;
		
		for(int i=0; i<houses.length; i++) {
			if(houses[i]>=checkPoint) {
				count++;
				checkPoint = houses[i] + dis;
				
				if(count>=C)
					return true;
			}
		}
		
		return false;
	}

}
