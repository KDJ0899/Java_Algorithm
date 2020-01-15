package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : theNumberOfIslands.java
  * @Project : Algorithm
  * @Date : 2019. 5. 22. 
  * @Author : Kim DongJin
  * @Comment : 백준 알고리즘 4963번 섬의 개수 문제
 */
public class theNumberOfIslands {
	
	static int count,w,h;
	static boolean  isIsland =false;

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			count=0;
			if(x==0&&y==0)
				break;
			
			w=y;
			h=x;
			
			int arr[][] =new int[y][x];
			
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0; i<y;i++) {
				for(int j=0; j<x;j++) {
					if(arr[i][j]==1) {
						count++;
						recursion(arr, i,j );
					}
				}
			}
			
			System.out.println(count);
		}
		sc.close();

	}
	
	public static void recursion(int[][] arr, int y, int x) {
		if(x<0||y<0||x>=h||y>=w)
			return;
		if(arr[y][x]==0)
			return;
		
		arr[y][x]=0;
		
		recursion(arr,y-1,x);
		recursion(arr,y-1,x-1);
		recursion(arr,y+1,x);
		recursion(arr,y+1,x+1);
		recursion(arr,y,x-1);
		recursion(arr,y+1,x-1);
		recursion(arr,y,x+1);
		recursion(arr,y-1,x+1);
		
		
		
	}

}
