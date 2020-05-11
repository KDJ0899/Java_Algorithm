package baekjoon;

import java.util.Queue;
import java.util.Scanner;

/**
 * 
  * @FileName : Escape.java
  * @Project : Algorithm
  * @Date : 2020. 5. 11. 
  * @Author : Kim DongJin
  * @Comment : 백준 3055번 탈출 문제 풀이
 */
public class Escape {
	
	static int bestTime = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		String[][] map = new String[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = sc.next();
			}
		}
		
		
	}
	
	public static void move(int x, int y, String[][] map, int time) {
		if(map[y][x].equals("D")) {
			bestTime = Math.max(bestTime, time);
			return;
		}
		else if(map[y][x].equals("X") || map[y][x].equals("*"))
			return;
		else if(!map[y][x].equals(".")&&!map[y][x].equals("S") && Integer.parseInt(map[y][x])>=time)
			return;
		
	}
	
	public static void flood(Queue<int[]> waters, String[][] map) {
		
		for(int[] water : waters) {
			
		}
	}

}
