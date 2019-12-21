/**
 * 
 */
package Programmers;

import java.util.HashMap;
import java.util.Map;

/**
  * @FileName : WayToSchool.java
  * @Project : Algorithm
  * @Date : 2019. 11. 30.
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적계획법 - 등굣길 문제.
 */
public class WayToSchool {
		
	static int a,b;
	static int shortest=Integer.MAX_VALUE;
	static Map<Integer, Integer> map;

	public static int solution(int m, int n, int[][] puddles) {
        boolean[][] road = new boolean[n][m];
        for(int i=0; i<puddles.length; i++) {
        	road[puddles[i][0]-1][puddles[i][1]-1]=true;
        }
        a=m;
        b=n;
        
        map = new HashMap<Integer, Integer>();
        search(0, 0, road,0);
        return map.get(shortest)%1000000007;
    }
	
	public static void search(int x,int y,boolean[][] road,int cnt) {
		if(road[y][x]||cnt>shortest)
			return;
		
		if(x==a-1&&y==b-1) {
			shortest= Math.min(cnt, shortest);
			if(map.containsKey(shortest))
				map.put(cnt, map.get(cnt)+1);
			else
				map.put(cnt, 1);
			return;
		}
		
		cnt++;
		
		if(x+1<a)
			search(x+1, y, road,cnt);
		if(y+1<b)
			search(x, y+1, road,cnt);
		if(x-1>0)
			search(x-1, y, road,cnt);
		if(y-1>0)
			search(x, y-1, road,cnt);

	}
	
	public static void main(String[] args) {
		
		System.out.println(solution(4, 3, new int[][] {{2,2}}));

	}

}
