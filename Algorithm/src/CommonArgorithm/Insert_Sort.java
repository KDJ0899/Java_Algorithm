package CommonArgorithm;

import java.util.Scanner;
/**
 * ��������(2.5~2.11 ������ ����)
 * 
 * �迭�� ��������� ȿ���� ����������, ������ �����ϴٴ� ������ �ִ�.
 * ���� �����̳� ��ǰ ���İ� ���� ���� O(n2) �˰��� ���Ͽ� ������, ���� �����̰� in-place �˰����̴�
 * 
 * @Package : OurAlgorism_February
 * @FileName : Insert_Sort.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 5. 
 *
 */
public class Insert_Sort {
	public static int[] InsertSort(int[] arr) {
		int k,a;
		for(int i=1;i<arr.length;i++) {
			a=i;
			for(int j=i-1;j>=0;j--) {
				if(arr[a]<arr[j]) {
					k=arr[j];
					arr[j]=arr[a];
					arr[a]=k;
					a=j;
				}
				else 
					break;
			}
			for(int j=0;j<arr.length;j++)
				System.out.print(arr[j]+" ");
			System.out.println();
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		arr=InsertSort(arr);
		System.out.print("Result:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
