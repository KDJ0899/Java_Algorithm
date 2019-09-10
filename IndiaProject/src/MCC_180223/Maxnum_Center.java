package MCC_180223;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 * 숫자 받아서 가운데 오른쪽 왼쪽 순으로 내림차순 정렬하기.
 * 
 * @Package : MCC_180223
 * @FileName : Maxnum_Center.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class Maxnum_Center {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);;
		System.out.print("Give the number of Integer:");
		int n=sc.nextInt();
		int cen=(n-1)/2,k=0;
		Integer[] arr=new Integer[n];
		int[] new_arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Original array:"+Arrays.toString(arr));
		Arrays.sort(arr, Collections.reverseOrder());

		if(n%2==0) {
			for(int i=0;i<n;i+=2) {
				new_arr[cen-k]=arr[i];
				new_arr[cen+1+k]=arr[i+1];
				k++;
			 }
		}//짝수 일때 정렬
		else {
			new_arr[cen]=arr[0];
			for(int i=1;i<n-1;i+=2) {
				new_arr[cen+1+k]=arr[i];
				new_arr[cen-1-k]=arr[i+1];
				k++;
			}		
		}//홀수 일때 정렬
		System.out.println("Rearraged array:"+Arrays.toString(new_arr));
	}
}
