package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : OrganicCabbage.java
  * @Project : Algorithm
  * @Date : 2020. 3. 28. 
  * @Author : Kim DongJin
  * @Comment : 백준 1012 유기농배추 문제 풀이 완료.
 */

public class OrganicCabbage {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int M, N, K, x, y, count = 0;
		boolean[][] map;
		
		for(int index=0; index<T; index++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new boolean[M][N];
			count = 0;
			
			for(int i=0; i<K; i++) {
				y = sc.nextInt();
				x = sc.nextInt();
				
				map[y][x] = true;
			}
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					
					if(map[i][j]) {
						search(j, i, map);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void search(int x, int y, boolean[][] map) {
		if(x<0||x>=map[0].length || y<0 || y>=map.length) return;
		if(!map[y][x]) return;
		
		map[y][x] = false;
		search(x+1, y, map);
		search(x-1, y, map);
		search(x, y-1, map);
		search(x, y+1, map);
		
		
	}

}
