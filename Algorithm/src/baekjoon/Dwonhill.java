package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : Dwonhill.java
  * @Project : Algorithm
  * @Date : 2020. 3. 18. 
  * @Author : Kim DongJin
  * @Comment :백준 DP 1520번 내리막길 문제 풀이 완료.
 */
public class Dwonhill {
	static int M,N;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		int[][] map = new int[M][N];
		int[][] routes = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		walk(0,0,map,routes);
		if(routes[0][0]==-1)
			System.out.println(0);
		else
			System.out.println(routes[0][0]);
		

		
	}
	
	public static int walk(int i, int j, int[][] map, int[][] routes) {
		if(routes[i][j] !=0) return routes[i][j];

		if(i==M-1&&j==N-1)
			return 1;
		
		int routeCount=-1;
		int nowHeight = map[i][j];
		
		if(i+1<M&&nowHeight>map[i+1][j]) { //Down
			routeCount = walk(i+1, j, map, routes);
			if(routeCount != -1) {
				routes[i][j]+=routeCount;
			}
		}
		
		if(i-1>=0&&nowHeight>map[i-1][j]) { //Up
			routeCount = walk(i-1, j, map, routes);
			if(routeCount != -1) {
				routes[i][j]+=routeCount;
			}
		}
		
		if(j+1<N&&nowHeight>map[i][j+1]) { //Right
			routeCount = walk(i, j+1, map, routes);
			if(routeCount != -1) {
				routes[i][j]+=routeCount;
			}
		}
		
		if(j-1>=0&&nowHeight>map[i][j-1]) { //Left
			routeCount = walk(i, j-1, map, routes);
			if(routeCount != -1) {
				routes[i][j]+=routeCount;
			}
		}
		
		if(routes[i][j]==0) {
			routes[i][j] = -1;
			return routes[i][j];
		}
		
		return routes[i][j];
		
	}

}
