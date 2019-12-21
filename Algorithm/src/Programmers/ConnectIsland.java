package Programmers;
/**
 * 
  * @FileName : ConnectIsland.java
  * @Project : Algorithm
  * @Date : 2019. 12. 21. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 탐욕법 섬 연결하기 문제 풀이 완료
 */
public class ConnectIsland {

	public static int solution(int n, int[][] costs) {
		int answer = 0;

		int[][] bridges = new int[n][n];
		int x, y, cost, count = 0, min,minIndex=-1;
		boolean[] connected = new boolean[n];

		for (int i = 0; i < costs.length; i++) {
			x = costs[i][0];
			y = costs[i][1];
			cost = costs[i][2];
			bridges[x][y] = cost;
			bridges[y][x] = cost;
		}

		connected[0] = true;

		while (count < n - 1) {
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (connected[i]) {
					for(int j=0; j<n; j++) {
						if(bridges[i][j]!=0&&!connected[j]&&min>bridges[i][j]) {
							min = bridges[i][j];
							minIndex = j;
							
						}
					}
				}
			}
			
			answer+=min;
			System.out.println(min +" "+ minIndex);
			connected[minIndex] = true;
			
			count++;
		}

		return answer;
	}

	public static void main(String[] args) {
		
//		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
		System.out.println(solution(4, new int[][] {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4}}));
//		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{2,3,1}}));

	}

}
