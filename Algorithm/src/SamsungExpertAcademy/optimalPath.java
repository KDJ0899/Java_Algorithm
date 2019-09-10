package SamsungExpertAcademy;

import java.util.Scanner;

/**
 * 
  * @FileName : optimalPath.java
  * @Project : Algorithm
  * @Date : 2019. 8. 9. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 1247. D5 최적 경로 문제 풀이
  * 		       가능하면 메모리 낭비 하지 않기 (순환하면서 리스트나 배열 복사 같은 것)
  * 		   11만kb 에서 2만kb 까지 줄일수 있음.
 */
public class optimalPath {
	
	static int[][] desArr;
	static int shortest,cNum;
	static boolean[] visited;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int exNum;
		
		
		exNum = sc.nextInt();
		
		for(int i=0; i<exNum; i++) {
			
			cNum = sc.nextInt();
			
			desArr = new int[cNum+2][2];
			visited = new boolean[cNum];
			
			for(int j=0; j<cNum+2; j++) {
				
				desArr[j][0]=sc.nextInt();
				desArr[j][1]=sc.nextInt();
			}
			shortest=-1;
			DP(0,0,0);
			
			System.out.println("#"+(i+1)+" "+shortest);
			
			
		}
		
		sc.close();

	}
	
	public static void DP(int distance,int count, int location) {
		
		if(count==cNum) {
			distance+=Math.abs(desArr[1][0]-desArr[location][0])+Math.abs(desArr[1][1]-desArr[location][1]);
			if(shortest==-1)
				shortest=distance;
			else
				shortest = Math.min(shortest, distance);
			
			return;
		}
	
	
		for(int i=2; i<cNum+2; i++) {
			if(!visited[i-2]) {
				visited[i-2]=true;
				DP(distance+Math.abs(desArr[i][0]-desArr[location][0])+Math.abs(desArr[i][1]-desArr[location][1]),
						count+1,i);
				visited[i-2]=false;
			}
		}
		
	}

}
