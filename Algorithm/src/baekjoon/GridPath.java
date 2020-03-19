package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : GridPath.java
  * @Project : Algorithm
  * @Date : 2020. 3. 19. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 10164 격자상의 경로 문제 풀이 완료. (정답률 33.371%)
 */
public class GridPath {

	static int N,M,x,y;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt(); 
		int K = sc.nextInt();
		boolean passed = true;
		
		int[][] road = new int[N][M];
		
		if(K!=0) {
			x = K/M;
			y = K%M-1;
			if(y==-1) {
				y = M-1;
				x--;
			}
			passed = false;
		}
		System.out.println(x+" "+y);
		System.out.println(walk(road, 0, 0, passed));
	}
	
	public static int walk(int[][] road, int i,int j,boolean passed) {
		if(i>=N||j>=M) return 0;
		if(road[i][j]!=0) return road[i][j];
		if(!passed&&(i>x||j>y)) return 0;
		if(!passed&&i==x&&j==y) passed = true;
		if(passed&&i==N-1&&j==M-1) return 1;
		
		return road[i][j]=walk(road, i+1, j, passed) + walk(road, i, j+1, passed);
	}

}
