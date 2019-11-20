package CommonArgorithm;


import java.util.Arrays;
import java.util.Scanner;
/**
 *  ��������(2.5~2.11 ������ ����)
 *  
 *  ���ڸ� ���� �˰���
 *  �ð����⵵ O(n^2)
 *  
 * @Package : OurAlgorism_February
 * @FileName : Select_Sort.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 5. 
 *
 */
public class Select_Sort {
	public static int[] SelectSort(int[] arr) {
		int min=9999,i=0,k = 0;
		for(i=0;i<arr.length;i++) {
			min=9999;
			for(int j=i;j<arr.length;j++) {
				if(min>arr[j]) {
					min=arr[j];
					k=j;
				}
			}
			arr[k]=arr[i];
			arr[i]=min;
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr=new int[10];
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<arr.length;i++) 
			arr[i]=sc.nextInt();
		System.out.print("Before Sorting:");
		System.out.println(Arrays.toString(arr));
		
		arr=SelectSort(arr);
		System.out.print("After Sorting:");
		System.out.println(Arrays.toString(arr));

		sc.close();
	}

}
