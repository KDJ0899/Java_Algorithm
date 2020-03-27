package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : GreedyPanda.java
  * @Project : Algorithm
  * @Date : 2020. 3. 27. 
  * @Author : Kim DongJin
  * @Comment : 백준 1937 욕심쟁이 판다 문제 풀이 완료. (정답률 29.765%)
 */
public class GreedyPanda {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] forest = new int[n][n];
		int[][] lifes = new int[n][n];	
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				forest[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, search(i, j, forest, lifes));
			}
		}		
		System.out.println(max);
		
	}
	
	
	public static int search(int i,int j, int[][] forest, int[][] lifes) {
		if(lifes[i][j] != 0) return lifes[i][j];
		
		int answer = Math.max(up(i, j, forest, lifes), down(i, j, forest, lifes));
		answer = Math.max(answer, left(i, j, forest, lifes));
		answer = Math.max(answer, right(i, j, forest, lifes));
		
		return lifes[i][j]=answer+1;
		
	}
	
	public static int up(int i, int j, int[][] forest, int[][] lifes) {
		if(i-1<0 || forest[i][j]>=forest[i-1][j] ) return 0;
		return search(i-1, j, forest, lifes);
	}
	public static int down(int i, int j, int[][] forest, int[][] lifes) {
		if(i+1>=forest.length || forest[i][j]>=forest[i+1][j] ) return 0;
		return search(i+1, j, forest, lifes);
	}
	public static int left(int i, int j, int[][] forest, int[][] lifes) {
		if(j-1<0 || forest[i][j]>=forest[i][j-1] ) return 0;
		return search(i, j-1, forest, lifes);
	}
	public static int right(int i, int j, int[][] forest, int[][] lifes) {
		if(j+1>=forest[0].length|| forest[i][j]>=forest[i][j+1] ) return 0;
		return search(i, j+1, forest, lifes);
	}

}
