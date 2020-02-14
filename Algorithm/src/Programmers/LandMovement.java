package Programmers;

import java.util.Arrays;
import java.util.List;
/**
 * 
  * @FileName : LandMovement.java
  * @Project : Algorithm
  * @Date : 2020. 2. 10. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 지형이동 문제.
 */
public class LandMovement {
	public int solution(int[][] land, int height) {
        int answer = 0;
        
        boolean[][] explored = new boolean[land.length][land.length];
        
        return answer;
    }
	
	public void explore(int[][] land, boolean[][] explored,int[][] group, int height, int i, int j) {
		
		explored[i][j] = true;
		int nowHeight = land[i][j];
		
		if(i-1>=0&&!explored[i-1][j]&&Math.abs(land[i-1][j]-nowHeight)<=height) {
			group[i-1][j]=group[i][j];
			explore(land, explored, group, height, i-1, j);
		}
		
		return;
	}
	
	
	public static void main(String[] args) {

		
	}
}
