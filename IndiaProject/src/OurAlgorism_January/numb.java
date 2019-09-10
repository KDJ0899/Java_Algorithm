package OurAlgorism_January;

import java.util.Scanner;
/**
 * 숫자를 회전으로 돌게 하기(실패)
 * 
 * @Package : OurAlgorism_January
 * @FileName : numb.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 26. 
 *
 */
public class numb {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] arr=new int[n][n];
		int cont=1,i=0,j=0,sw=0,end_i=n-1,end_j=n-1;
		while(true) {
			if(cont==n*n)
				break;
			switch(sw) {
			case 0:
				arr[i][j]=cont;
				cont++;
				j++;
				if(j>end_j) {
					j--;
					i++;
					end_j=n-end_j-1;
					sw=1;
				}
				break;
			case 1:
				arr[i][j]=cont++;
				i++;
				if(i>end_i) {
					i--;
					j--;
					end_i=n-end_i;
					sw=2;
				}
				break;
			case 2:
				arr[i][j]=cont++;
				j--;
				if(j<end_j) {
					j++;
					i--;
					end_j=n-end_j-1;
					sw=3;
				}
				break;
			case 3:
				arr[i][j]=cont++;
				i--;
				if(i<end_i) {
					i++;
					j++;
					end_i=n-end_i-1;
					sw=1;
				}
				break;
			default: break;
			}
			
			
		}

		for(int k=0;k<n;k++) {
			for(int l=0;l<n;l++)
				System.out.print(arr[k][l]+"  ");
			System.out.println();
		}
	}

}
