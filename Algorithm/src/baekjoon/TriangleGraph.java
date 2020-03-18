package baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : TriangleGraph.java
  * @Project : Algorithm
  * @Date : 2020. 3. 18. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 4883번 삼각 그래프 문제 풀이 완료.
 */
public class TriangleGraph {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int index = 1,frontPart,backPart;
		
		while(true) {
			int N = sc.nextInt();
			
			if(N==0)
				break;
			int[][] graph = new int[N][3];
			
			for(int i=0; i<N; i++) {
				graph[i][0] = sc.nextInt();
				graph[i][1] = sc.nextInt();
				graph[i][2] = sc.nextInt();
			}
			
			graph[0][0] = 1001;
			graph[0][2]+= graph[0][1];
			graph[N-1][2] = 1001;
			
			for(int i=1; i<N; i++) {
				frontPart = Math.min(graph[i-1][0], graph[i-1][1]);
				graph[i][0]+= frontPart;
				
				backPart = Math.min(graph[i-1][1], graph[i-1][2]);
				graph[i][1]+= Math.min(graph[i][0], Math.min(frontPart, backPart));
				
				graph[i][2]+= Math.min(graph[i][1], backPart);
				
			}
			
			System.out.println(index+". "+graph[N-1][1]);
			
			index++;
			
		}

	}

}
