package CommonArgorithm;

import java.util.Arrays;
import java.util.Scanner;
/**
 * ��������(2.5~2.11 ������ ����)
 * 
 * �� ������ ���Ҹ� �˻��Ͽ� �����ϴ� ����̴�. �ð� ���⵵�� O(n^2) �� ����� ��������, �ڵ尡 �ܼ��ϱ� ������ ���� ���ȴ�
 * @Package : OurAlgorism_February
 * @FileName : Bubble_Sort.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 6. 
 *
 */
public class Bubble_Sort {
	public static int[] BubbleSort(int[] arr) {
		int count=1,n=1,k;
		while(true) {
			if(count==0)
				break;
			count=0;
			System.out.println(n+"th sort");
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					k=arr[i+1];
					arr[i+1]=arr[i];
					arr[i]=k;
					count++;
				}
				System.out.println(Arrays.toString(arr));
			}
			n++;
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Before Sort:"+Arrays.toString(arr));
		arr=BubbleSort(arr);
		System.out.println("After Sort:"+Arrays.toString(arr));
	}

}
