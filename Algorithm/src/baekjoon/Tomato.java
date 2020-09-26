package baekjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * 
  * @FileName : Tomato.java
  * @Project : Algorithm
  * @Date : 2020. 9. 26. 
  * @Author : Kim DongJin
  * @Comment :백준 7576번 토마토 문제 풀이 완료
 */
public class Tomato {
	
	int x;
	int y;
	
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), M = sc.nextInt(), day = 0;
		int[] dx = new int[] {-1, 1, 0, 0}, dy = new int[] {0, 0, 1,-1};
 		int[][] box = new int[M][N];
		
		Queue<Tomato> today = new LinkedList<Tomato>();
		Queue<Tomato> tomorrow = new LinkedList<Tomato>();
		Set<String> unripeTomato = new HashSet<String>();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				int tomato = sc.nextInt();
				
				if(tomato == 1)
					tomorrow.add(new Tomato(j, i));
				else if(tomato == 0)
					unripeTomato.add(j+" "+i);
				box[i][j] = tomato;
			}
		}
		while(!tomorrow.isEmpty()) {
			
			today.addAll(tomorrow);
			tomorrow = new LinkedList<Tomato>();
			while(!today.isEmpty()) {
				Tomato tomato = today.poll();
				int x = tomato.x, y = tomato.y;
				
				for(int i=0; i<4; i++) {
					if(x+dx[i]<N && x+dx[i]>=0 && y+dy[i]>=0 && y+dy[i]<M) {
						if(box[y+dy[i]][x+dx[i]] == 0) {
							tomorrow.add(new Tomato(x+dx[i], y+dy[i]));
							box[y+dy[i]][x+dx[i]] = 1;
							unripeTomato.remove((x+dx[i])+" "+(y+dy[i]));
						}
					}
				}
			}
			day++;
		}
		
		if(!unripeTomato.isEmpty())
			day = -1;
		if(day>0)
			day--;
		System.out.println(day);
	}
	
}
