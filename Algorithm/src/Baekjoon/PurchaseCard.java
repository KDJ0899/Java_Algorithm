package Baekjoon;

import java.util.Scanner;
/**
 * 
  * @FileName : PurchaseCard.java
  * @Project : Algorithm
  * @Date : 2019. 12. 15. 
  * @Author : Kim DongJin
  * @Comment : 백준 11052번 카드구매하기 문제 완료
 */

public class PurchaseCard {

	public static void main(String[] args) {
		Scanner scA=new Scanner(System.in);
		
		int k;
		int N=scA.nextInt();
		int[] P = new int[N];
		int[] Pa= new int[N];
		
		for(int o=0;o<N;o++) {
			P[o]=scA.nextInt();
		}
		Pa=P;
		for (int i=0;i<N;i++) {
			k=i-1;
			for(int j=0;j<i;j++) {
				if(Pa[i]<Pa[j]+Pa[k])
					Pa[i]=Pa[j]+Pa[k];
				k--;
			}
		}
		
		System.out.println(Pa[N-1]);
		
	}

}
