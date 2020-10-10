package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
  * @FileName : HideAndSeek.java
  * @Project : Algorithm
  * @Date : 2020. 10. 9. 
  * @Author : Kim DongJin
  * @Comment : 백준 13913번 숨바꼭질4 문제 풀이 완료.
 */
public class HideAndSeek {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), K = sc.nextInt(), now, next, MAX = 200001;
		Queue<Integer> locations = new LinkedList<Integer>();
		int[] index = new int[MAX], parent = new int[MAX];
		
		
		locations.offer(N);
		
		while(!locations.isEmpty()) {
			 now = locations.poll();
			 
			 if(now == K)
				 break;
			 
			 if(index[now+1] == 0 && now+1 < MAX) {
				 locations.offer(now + 1);
				 index[now+1] = index[now]+1;
				 parent[now+1] = now;
			 }
			 
			 if(now != 0) {
				 if(index[now-1] == 0) {
					 locations.offer(now - 1);
					 index[now-1] = index[now]+1;
					 parent[now-1] = now;
				 }
				 if(index[now*2] == 0 && now*2 < MAX) {
					 locations.offer(now * 2);
					 index[now*2] = index[now]+1;
					 parent[now*2] = now;
				 }
			 }
		}
		
		System.out.println(index[K]);
		Stack<Integer> stack = new Stack<Integer>();
		now = K;
		
		while(now != N) {
			stack.push(now);
			now = parent[now];
		}
		
		stack.push(N);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}

}
