package kakao_internship_2020;

import java.util.*;

/**
 * 
 * @FileName : CaveExploration.java
 * @Project : Algorithm
 * @Date : 2020. 10. 7.
 * @Author : Kim DongJin
 * @Comment : 카카오 2020 인턴십 5번 동굴 탐험 문제 재풀이.
 */
public class CaveExploration {
	public static boolean solution(int n, int[][] path, int[][] order) {
		boolean answer = true;

		boolean[] visted = new boolean[n];
		int count = 0;
		int[] condition = new int[n];
		List<Integer>[] load = new ArrayList[n];
		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < order.length; i++) {
			condition[order[i][1]] = order[i][0];
		}
		for (int i = 0; i < path.length; i++) {
			if(load[path[i][0]] == null)
				load[path[i][0]] = new ArrayList<Integer>();
			load[path[i][0]].add(path[i][1]);
			if(load[path[i][1]] == null)
				load[path[i][1]] = new ArrayList<Integer>();
			load[path[i][1]].add(path[i][0]);
		}

		que.add(0);

		while (!que.isEmpty()) {
			int num = que.poll();

			if (condition[num] != 0 && !visted[condition[num]]) {
				if(count > que.size())
					return false;
				que.add(num);
				count++;
			} else {
				visted[num] = true;
				count = 0;
				for (int i : load[num]) {
					if (!visted[i])
						que.add(i);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(9,
				new int[][] { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } },
				new int[][] { { 8, 7 }, { 6, 5 }, { 4, 1 } }));

		System.out.println(solution(9,
				new int[][] { { 8, 1 }, { 0, 1 }, { 1, 2 }, { 0, 7 }, { 4, 7 }, { 0, 3 }, { 7, 5 }, { 3, 6 } },
				new int[][] { { 4, 1 }, { 5, 2 } }));
	}

}
