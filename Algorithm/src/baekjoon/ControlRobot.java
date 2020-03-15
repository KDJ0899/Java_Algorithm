package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
  * @FileName : ControlRobot.java
  * @Project : Algorithm
  * @Date : 2020. 3. 14. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 2169번 로봇 조종하기 문제 풀이. 
 */

class Robot{
	int x;
	int y;
	int value;
	String direction;
	
	public Robot(int x, int y, int value,String direction) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.direction = direction;
	}
	
	public void move(int x, int y, int[][] mars, int[][] bestWay, Queue<Robot> moves,String direction) {
		int nowValue = value+mars[y][x];
		
		if(nowValue>=bestWay[y][x]) {
			bestWay[y][x] = nowValue;
		}
		
		moves.offer(new Robot(x, y, nowValue, direction));
		
	}
	
	public void down(int N, int M, int[][] mars, int[][] bestWay, Queue<Robot> moves) {
		if(y+1>=N)
			return;
		
		move(x, y+1, mars,bestWay,moves,"Down");
	}
	
	public void left(int N, int M, int[][] mars, int[][] bestWay, Queue<Robot> moves) {
		if(x-1<0 || direction.equals("Right")||y==N-1)
			return;
		
		move(x-1, y, mars,bestWay,moves,"Left");
		
	}
	
	public void right(int N, int M, int[][] mars, int[][] bestWay, Queue<Robot> moves) {
		if(x+1>=M || direction.equals("Left"))
			return;
		
		move(x+1, y, mars,bestWay,moves,"Right");
	}
	
}
public class ControlRobot {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] mars = new int[N][M];
		int[][] bestWay = new int[N][M];
		Robot robot;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mars[i][j] = sc.nextInt();
				bestWay[i][j] = (int) -2e9;
			}
		}
		
		Queue<Robot> moves = new LinkedList<Robot>();
		moves.offer(new Robot(0, 0, mars[0][0], ""));
		
		while(!moves.isEmpty()) {
			
			robot = moves.poll();
			
			robot.right(N, M, mars, bestWay, moves);
			robot.left(N, M, mars, bestWay, moves);
			robot.down(N, M, mars, bestWay, moves);
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(bestWay[i]));
		}
		
		System.out.println(bestWay[N-1][M-1]);
	}

}
