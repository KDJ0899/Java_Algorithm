package Programmers;
/**
 * 
  * @FileName : Pedestrianparadise.java
  * @Project : Algorithm
  * @Date : 2020. 3. 26. 
  * @Author : Kim DongJin
  * @Comment : 2017 카카오 예선 보행자 천국 문제 풀이
 */
public class Pedestrianparadise {

	static int MOD = 20170805;
	static int M,N;
	public static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		int [][] driveMap = new int[m][n];
		M = m-1; 
		N= n-1;
		answer = drive(0, 0, cityMap, driveMap, Direction.RIGHT);
		return answer%MOD;
	}
	
	public static int drive(int x, int y,int[][] cityMap,int[][] driveMap, Direction direction) {
		if(cityMap[y][x] == 1) return 0;
		if(M==y&&N==x) return 1;
		if(cityMap[y][x]==2) {
			driveMap[y][x] = direction.move(x, y, cityMap, driveMap)%MOD;
		}
		else {
			if(driveMap[y][x] !=0&& cityMap[y][x]==0) return driveMap[y][x];
			driveMap[y][x]+= Direction.DOWN.move(x, y, cityMap, driveMap)%MOD;
			driveMap[y][x]+= Direction.RIGHT.move(x, y, cityMap, driveMap)%MOD;
		}
		
		return driveMap[y][x]%MOD;
	}
	
	enum Direction{
		DOWN{
			@Override
			public int move(int x, int y,int[][] cityMap,int[][] driveMap) {
				if(y+1>M)
					return 0;
				int result = drive(x, y+1, cityMap, driveMap, Direction.DOWN);
				return result%MOD;
			}
		},
		RIGHT{
			@Override
			public int move(int x, int y,int[][] cityMap,int[][] driveMap) {
				if(x+1>N)
					return 0;
				int result = drive(x+1, y, cityMap, driveMap, Direction.RIGHT);
				return result%MOD;
			}
		};
		
		public abstract int move(int x,int y,int[][] cityMap,int[][] driveMap);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(3, 6, new int[][] { {0, 2, 0, 0, 0, 2},
												        {0, 0, 2, 0, 1, 0},
												        {1, 1, 0, 2, 2, 0}}));
		}
		
	}
