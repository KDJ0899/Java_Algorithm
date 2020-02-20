package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
  * @FileName : GameMapShortestDistance.java
  * @Project : Algorithm
  * @Date : 2020. 2. 20. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 게임 맵 최단거리 문제 풀이 (정확성 테스트 통과, 효율성 테스트 불통과)
 */

class Player{
	int x;
	int y;
	int distance;
	
	public Player(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public void move(int x, int y, int distance, int[][]maps, int[][] distanceInfo,Queue<Player> nextSteps) {
		
		if(distanceInfo[y][x]!=0&&distanceInfo[y][x]<distance)
			return;
		
		distanceInfo[y][x] = distance;
		nextSteps.offer(new Player(x,y,distance));
	}
	
	public void up(int distance, int[][] maps, int[][] distanceInfo,Queue<Player> nextSteps) {
		
		if(y-1<0||maps[y-1][x]==0)
			return;
		
		move(x,y-1,distance+1,maps,distanceInfo,nextSteps);
	}
	public void down(int distance, int[][] maps, int[][] distanceInfo,Queue<Player> nextSteps) {
		
		if(y+1>=maps.length||maps[y+1][x]==0)
			return;
		
		move(x,y+1,distance+1,maps,distanceInfo,nextSteps);
	}
	public void left(int distance, int[][] maps, int[][] distanceInfo,Queue<Player> nextSteps) {
		
		if(x-1<0||maps[y][x-1]==0)
			return;
		
		move(x-1,y,distance+1,maps,distanceInfo,nextSteps);
	}
	public void right(int distance, int[][] maps, int[][] distanceInfo,Queue<Player> nextSteps) {
		
		if(x+1>=maps[0].length||maps[y][x+1]==0)
			return;
		
		move(x+1,y,distance+1,maps,distanceInfo,nextSteps);
	}
}
public class GameMapShortestDistance {
	public static int solution(int[][] maps) {
		int answer = 0;
		Player player;
		int distance, yMax = maps.length,xMax = maps[0].length;
		int[][] distanceInfo = new int[yMax][xMax];
		Queue<Player> nextSteps = new LinkedList<Player>();
		
		nextSteps.offer(new Player(0, 0, 1));
		
		while(!nextSteps.isEmpty()) {
			player = nextSteps.poll();
			distance = player.distance;
			
			player.up(distance, maps, distanceInfo, nextSteps);
			player.down(distance, maps, distanceInfo, nextSteps);
			player.left(distance, maps, distanceInfo, nextSteps);
			player.right(distance, maps, distanceInfo, nextSteps);
		}

		if(distanceInfo[yMax-1][xMax-1]==0)
			answer = -1;
		else
			answer = distanceInfo[yMax-1][xMax-1];
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	


}
