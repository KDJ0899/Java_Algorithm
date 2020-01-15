package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : jump.java
  * @Project : Algorithm
  * @Date : 2019. 5. 27. 
  * @Author : Kim DongJin
  * @Comment : 1890번 점프 문제 풀이 (dfs로 풀이, 답의 숫자가 커져 long형으로 선언 , test메소드는 초기 형태, dfs메소드는 메모이제이션 사용)
 */

public class jump {
	static int n;
	static long count=0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		long arr[][] = new long[n][n];		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		if(arr[0][0]==0)
			return;
		
		dfs(arr,0,0);
		
		System.out.println(count);

	}
	
	public static long dfs(long[][] arr, int i , int j) {
		 if(i>=n||j>=n)
			 return 0;
		 
		 if(i==n-1&&j==n-1) {
			 count++;
			 return -1;
		 }
		 if(arr[i][j]==0)
			 return 0;
		 
		 if(arr[i][j]<0) {
			 count-=arr[i][j];
			 return arr[i][j];
		 }
		 long a=arr[i][j];
		 arr[i][j]=0;
		 
		 arr[i][j]+=dfs(arr,(int)(i+a),j);
		 arr[i][j]+=dfs(arr,i,(int)(j+a));

		 return arr[i][j]; 
	}
	
	
	public static void test(int arr[][],int i, int j) {
		 if(i>=n||j>=n)
			 return;
		 
		 if(i==n-1&&j==n-1) {
			 count++;
			 return;
		 }
		 if(arr[i][j]==0)
			 return;
		 int a=arr[i][j];
		 
		 test(arr,i+a,j);
		 test(arr,i,j+a);
	}

}
