package OurAlgorism_February;

import java.util.Scanner;

/**
 * 백준 4811번 알약 문제(2.12~15 문제풀기)
 * 
 * @Package : OurAlgorism_February
 * @FileName : pill.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 12. 
 * 
 */
public class pill {
	static long cont=0;
	static int[][] arr;
	public static void eatpill(int n,int half) {
		if(half==0) {
			eatpill(--n,++half);
		}
	/*	else if(n==2) {
			n--;
			for(int i=half+1;i>0;i--) {
				cont+=n+i;
			}
		}
		else if(n==1) {
			cont+=n+half;
		}*/
		else if(n==0) {
			cont+=1;
		}
		else {
			n--;
			half++;
			eatpill(n,half);
			n++;
			half-=2;
			eatpill(n, half);
		}	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int half=0;
		eatpill(n,half);
		System.out.println(cont);
	}

}
