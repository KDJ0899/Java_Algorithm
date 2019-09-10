package MCC_180205;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		int[] marks=new int[5];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<marks.length;i++)
			marks[i]=sc.nextInt();
		System.out.println("Before sorting"+Arrays.toString(marks));
		Arrays.sort(marks);
		System.out.println("After sorting"+Arrays.toString(marks));
		sc.close();
	}
}
