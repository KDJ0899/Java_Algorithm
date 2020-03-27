package baekjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * 
  * @FileName : Guitarist.java
  * @Project : Algorithm
  * @Date : 2020. 3. 27. 
  * @Author : Kim DongJin
  * @Comment : 백준 1495번 기타리스트 문제 풀이 완료.
 */
public class Guitarist {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int[] V = new int[N+1];
		
		int answer =-1;
		
		Map<Integer, Set<Integer>> results = new HashMap<Integer, Set<Integer>>();
		Set<Integer> volumes = new HashSet<Integer>();
		
		volumes.add(S);
		results.put(0, volumes);
		
		for(int i=1; i<=N; i++) {
			V[i] = sc.nextInt();
			volumes = new HashSet<Integer>();
			
			for(int volume : results.get(i-1)) {
				if(volume + V[i]<=M)
					volumes.add(volume + V[i]);
				if(volume - V[i]>=0)
					volumes.add(volume - V[i]);
			}
			results.put(i, volumes);
		}
		
		for(int volume : results.get(N)) {
			answer = Math.max(answer, volume);
		}
		
		System.out.println(answer);
		
	}
	
}
