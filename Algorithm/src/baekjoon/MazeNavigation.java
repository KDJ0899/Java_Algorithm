package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
  * @FileName : MazeNavigation.java
  * @Project : Algorithm
  * @Date : 2020. 9. 25. 
  * @Author : Kim DongJin
  * @Comment : 백준 2178번 미로 탐색 문제 풀이 완료.
 */
public class MazeNavigation {

	static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int N,M;
    
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			char[] wall = line.toCharArray();

			for (int j = 0; j < wall.length; j++) {
				map[i][j] = Integer.parseInt(wall[j] + "");
			}
		}

		bfs(0, 0);

		System.out.println(map[N-1][M-1]);

	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int location[] = q.poll();
			visited[i][j] = true;

			for (int dir = 0; dir < 4; dir++) {
				int r = location[0] + dr[dir];
				int c = location[1] + dc[dir];

				if (r >= 0 && c >= 0 && r < N && c < M) {
					if (map[r][c] != 0 && !visited[r][c]) {
						q.offer(new int[] { r, c });
						visited[r][c] = true;
						map[r][c] = map[location[0]][location[1]] + 1;
					}
				}
			}
		}
	}
}
