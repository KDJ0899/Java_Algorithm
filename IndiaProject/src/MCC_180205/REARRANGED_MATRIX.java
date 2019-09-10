package MCC_180205;

import java.util.Arrays;
import java.util.Scanner;

public class REARRANGED_MATRIX {

	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		System.out.print("INPUT: M=");
		int M=sc.nextInt();
		System.out.println("OutPut:");
		if(M<=3||M>=10) {
			System.out.println("THE MATRIX SIZE IS OUT OF RANGE");
			return;
		}
		int[][] arr=new int[M][M];
		int[] sort_arr=new int[(M-2)*(M-2)];
		int index=0,sum=0;

		for(int i=0;i<M;i++)
			for(int j=0;j<M;j++)
				arr[i][j]=sc.nextInt();
		System.out.println("ORIGINAL MATRIX");
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				if(i>0&&i<M-1&&j>0&&j<M-1) {
					sort_arr[index]=arr[i][j];
					index++;
				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<sort_arr.length;i++) {
			Arrays.sort(sort_arr);
		}
		index=0;
		System.out.println("REARRAMGED MATRIX");
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				if(i>0&&i<M-1&&j>0&&j<M-1) {
					arr[i][j]=sort_arr[index];
					index++;
				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("DIAGONAL ELEMENTS");
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				if(i+j==M-1||i==j) {
					System.out.print(arr[i][j]+" ");
					sum+=arr[i][j];
				}
				else
					System.out.print("   ");
			}
			System.out.println();
		}
		System.out.println("SUM OF THE DIAGONAL ELEMENTS= "+sum);
	}
}
