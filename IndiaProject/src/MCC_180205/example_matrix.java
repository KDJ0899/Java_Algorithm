package MCC_180205;

import java.util.Arrays;
import java.util.Scanner;

public class example_matrix {

	public static void main(String[] args) {
		int[][] arr=new int[3][3];
		Scanner sc=new Scanner(System.in);
		System.out.println("InPut:");
		int min=0,k=0,max1=-1,max2=-1,row1=0,row2=0,column1=0,column2=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]>max1) {
					max1=arr[i][j];
					row1=i+1;
					column1=j+1;
				}
				else if(arr[i][j]>max2) {
					max2=arr[i][j];
					row2=i+1;
					column2=j+1;
				}
			}
		}
		System.out.println("OutPut:");
		for(int i=0;i<3;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("The largest element "+max1+" is in row "+row1+" and column "+column1);
		System.out.println("The second largest element "+max2+" is in row "+row2+" and column "+column2);
		for(int i=0;i<3;i++) {
			Arrays.sort(arr[i]);
		}
		System.out.println("After Sorting");
		for(int i=0;i<3;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
