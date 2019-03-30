package OurAlgorism_February;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 버블정렬(2.5~2.11 일주일 과제)
 * 
 * 두 인접한 원소를 검사하여 정렬하는 방법이다. 시간 복잡도가 O(n^2) 로 상당히 느리지만, 코드가 단순하기 때문에 자주 사용된다
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
