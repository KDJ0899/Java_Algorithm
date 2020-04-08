package SamsungExpertAcademy;

import java.util.Scanner;
/**
 * 
  * @FileName : Maze1.java
  * @Project : Algorithm
  * @Date : 2020. 4. 8. 
  * @Author : Kim DongJin
  * @Comment :SW Expert Academy 1226. D4 미로1 문제 풀이 완료.
 */
public class Maze1 {
	static boolean finish;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num, answer;
		String wall;
		char[][] maze;
		for(int test_case = 1; test_case <= 1; test_case++) {
			num = sc.nextInt();
			maze = new char[16][16];
			finish = false;
			answer = 0;
			for(int i=0; i<16; i++) {
				wall = sc.next();
				maze[i] = wall.toCharArray();
			}
			search(maze, 1, 1);
			
			if(finish)
				answer = 1;
			
			System.out.println("#"+test_case+" "+answer);
				
		}
	}
	
	public static void search(char[][] maze,int i, int j) {
		if(finish)
			return;
		if(i>16 || i<0 || j>16 || j<0)
			return;
		if(maze[i][j] == '1') 
			return;
		if(maze[i][j] == '3') {
			finish = true;
			return;
		}
		maze[i][j] = '1';
		search(maze, i+1, j);
		search(maze, i-1, j);
		search(maze, i, j+1);
		search(maze, i, j-1);
			
	}
}
