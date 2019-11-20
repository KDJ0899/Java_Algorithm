package CommonArgorithm;

import java.util.Arrays;
import java.util.Scanner;
/**
 * �� ���� (2.5~2.11 ������ ����)
 * 
 * �ٸ� ���ҿ��� �񱳸����� ������ �����ϴ� �� ����
 * ������ n���� �����͸� ������ ��, �־��� ��쿡�� O(n^2)���� �񱳸� �����ϰ�, ��������� O(n log n)���� �񱳸� �����Ѵ�
 * ��κ��� �������� �����͸� ������ �� ���� �ð��� �ɸ� Ȯ���� ���� ������ �˰����� �����ϴ� ���� �����ϴ�. 
 * ������ �Ϲ����� ��� �� ������ �ٸ� O(n log n) �˰��� ���� �ξ� ������ �����Ѵ�. 
 * �׸��� �� ������ ������ ���� O(log n)��ŭ�� memory�� �ʿ���Ѵ�. ���� �� ������ �Ҿ��� ���Ŀ� ���Ѵ�.
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
