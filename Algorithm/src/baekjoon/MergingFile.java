package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : MergingFile.java
  * @Project : Algorithm
  * @Date : 2020. 3. 17. 
  * @Author : Kim DongJin
  * @Comment : 백준 DP 11066번 파일 합치기 문제 풀이 완료. knuth's optimization (크눅스 최적화)
 */
public class MergingFile {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int K,num; 
		int[] files;
		int[][] newFiles;
		
		for(int i=0; i<T; i++) {
			K = sc.nextInt();
			files = new int[K+1];
			newFiles = new int[K][K];
			
			for(int j=1; j<K+1; j++) {
				num = sc.nextInt();
				files[j] = files[j-1] +num;
			}
			System.out.println(merge(files, newFiles, 0, K-1));
		}
		
		
	}
	
	public static int merge(int[] files, int[][] newFiles,int start, int end) {
		if(start>end) return 999999999;
		if(newFiles[start][end]!=0) return newFiles[start][end];
		if(start==end) return 0;
		
		newFiles[start][end] = 999999999;
		
		int front,back;
		
		for(int i=start; i<end; i++ ) {
			front = merge(files, newFiles, start, i);
			back = merge(files, newFiles, i+1, end);
			
			newFiles[start][end] = Math.min(newFiles[start][end],front+back);
		}
		newFiles[start][end] += files[end+1] - files[start];		
		return newFiles[start][end];
	}

}
