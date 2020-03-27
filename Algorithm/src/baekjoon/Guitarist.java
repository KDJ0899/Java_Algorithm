package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : Guitarist.java
  * @Project : Algorithm
  * @Date : 2020. 3. 27. 
  * @Author : Kim DongJin
  * @Comment : 백준 1495번 기타리스트 문제 풀이.
 */
public class Guitarist {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int[] V = new int[N];
		
		for(int i=0; i<N; i++) {
			V[i] = sc.nextInt();
		}
		
		System.out.println(controlVolume(V, S, M, 0));
	}
	
	public static int controlVolume(int[] volumes, int nowVolume, int max, int i) {
		if(nowVolume>max||nowVolume<0) return -1;
		if(i==volumes.length) return nowVolume;
		
		return Math.max(controlVolume(volumes, nowVolume+volumes[i], max, i+1), controlVolume(volumes, nowVolume-volumes[i], max, i+1));
	}

}
