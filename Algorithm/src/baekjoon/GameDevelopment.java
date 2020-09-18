package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @FileName : GameDevelopment.java
 * @Project : Algorithm
 * @Date : 2020. 9. 18.
 * @Author : Kim DongJin
 * @Comment : 백준 1516 게임개발 문제 풀이 완료.
 */
public class GameDevelopment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer>[] list = new ArrayList[N];
		int[] indegree = new int[N];
		int[] value = new int[N];
		int[] result = new int[N];
		int temp = 0;

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
			value[i] = sc.nextInt();
			temp = sc.nextInt();
			while (temp != -1) {
				indegree[i]++;
				list[temp - 1].add(i);
				temp = sc.nextInt();
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				result[i] = value[i];

			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				result[next] = Math.max(result[next], result[current] + value[next]);

				if (indegree[next] == 0) {
					queue.add(next);
				}
			}

		}
		for (int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
	}

}
