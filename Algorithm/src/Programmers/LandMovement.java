package Programmers;

import java.util.List;

public class LandMovement {
	public int solution(int[][] land, int height) {
        int answer = 0;
        
        boolean[][] explored = new boolean[land.length][land.length];
        
        return answer;
    }
	
	public void explore(int[][] land, boolean[][] explored,List<int[]> group, int height, int i, int j) {
		
		if(i<0||i>land.length-1||j<0||j>land.length-1)
			return;
		if(explored[i][j])
			return;
		
		explored[i][j] = true;
		group.add(new int[] {i,j});
	
		
		
		
		
		
		return;
	}
}
