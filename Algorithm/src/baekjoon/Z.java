package baekjoon;

import java.util.Scanner;

/**
 * 백준 1074번 Z문제
 * 
 * @Package : OurAlgorism_February
 * @FileName : Z.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 13. 
 * 
 */
public class Z {
	static int x,y,cont=0;
	public static void Z(int length,int i,int j) {
		if(length>2) {
			Z(length/2,i,j);
			Z(length/2,i,j+length/2);
			Z(length/2,i+length/2,j);
			Z(length/2,i+length/2,j+length/2);
		}
		else {
			for(int a=i;a<i+2;a++) {
				for(int b=j;b<j+2;b++) {
					if(x==a&&y==b)
						System.out.println(cont);
					cont++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		Z((int)(Math.pow(2, n)),0,0);
	}
}
