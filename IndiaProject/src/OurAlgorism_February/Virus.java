package OurAlgorism_February;

import java.util.Scanner;
/**
 * 백준 2606번 바이러스 문제
 * 
 * @Package : OurAlgorism_February
 * @FileName : Virus.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class Virus {
	static int cont=0,n;
	static int[] infect;
	public static void check(int[][] arr,int parent) {
		for(int i=0;i<n;i++) {
			if(infect[i]==1)
				continue;
			if(arr[parent][i]==1) {
				infect[i]=1;       
				check(arr,i);    
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int command=sc.nextInt();
		int parent,child,cont=0;;
		int[][] arr=new int[n][n];
		infect=new int[n];
		infect[0]=1;
		for(int i=0;i<command;i++) {
			parent=sc.nextInt();
			child=sc.nextInt();
			arr[parent-1][child-1]=1;
			arr[child-1][parent-1]=1;
		}
		check(arr,0);
		for(int i=1;i<n;i++) {
			if(infect[i]==1)
				cont++;
		}
		System.out.println(cont);
		}
}