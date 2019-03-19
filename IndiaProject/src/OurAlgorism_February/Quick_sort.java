package OurAlgorism_February;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 퀵 정렬 (2.5~2.11 일주일 과제)
 * 
 * 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬
 * 정렬은 n개의 데이터를 정렬할 때, 최악의 경우에는 O(n^2)번의 비교를 수행하고, 평균적으로 O(n log n)번의 비교를 수행한다
 * 대부분의 실질적인 데이터를 정렬할 때 제곱 시간이 걸릴 확률이 거의 없도록 알고리즘을 설계하는 것이 가능하다. 
 * 때문에 일반적인 경우 퀵 정렬은 다른 O(n log n) 알고리즘에 비해 훨씬 빠르게 동작한다. 
 * 그리고 퀵 정렬은 정렬을 위해 O(log n)만큼의 memory를 필요로한다. 또한 퀵 정렬은 불안정 정렬에 속한다.
 * @Package : OurAlgorism_February
 * @FileName : Quick_sort.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 7. 
 *
 */
public class Quick_sort {
	public static int[] QuickSort(int[] arr,int left,int right) {
		int pivot=arr[right];
		System.out.println("pivot:"+pivot);
		int l_cont=left,r_cont=right-1,k;
		while(true) {
			if(l_cont>r_cont)
				break;
			else {
				if(arr[l_cont]<pivot) 
					l_cont++;
				else if(arr[r_cont]>=pivot)
					r_cont--;
				else {
					k=arr[l_cont];
					arr[l_cont]=arr[r_cont];
					arr[r_cont]=k;
					l_cont++;
					r_cont--;
				}
			}
		}
		arr[right]=arr[l_cont];
		arr[l_cont]=pivot;
		System.out.println(Arrays.toString(arr));
		if(left<l_cont-1)
			arr=QuickSort(arr,left,l_cont-1);
		if(l_cont+1<right)
			arr=QuickSort(arr,l_cont+1,right);
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		int left=0,right=arr.length-1;
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		System.out.println("Before Sort:"+Arrays.toString(arr));
		QuickSort(arr, left, right);
		System.out.println("After Sort:"+Arrays.toString(arr));

	}

}
