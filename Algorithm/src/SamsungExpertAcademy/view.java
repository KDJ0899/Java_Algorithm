/**
 *
 */
package SamsungExpertAcademy;

import java.util.Scanner;

/**
  * @FileName : view.java
  * @Project : Algorithm
  * @Date : 2019. 7. 9. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 1206. D3 View 문제 풀이
 */
public class view {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length,count,max,num;
		boolean next;
		int[] arr;
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			length = sc.nextInt();
			arr = new int[length];
			count=0;
			
			for(int j=0; j<length; j++) {
				arr[j]=sc.nextInt();
			}
			
			for(int j=2; j<length-2; j++) {
				max=0;
				next = false;
				num = arr[j];
				
				for(int a=0; a<5; a++) {
					if(a!=2) {
						if(arr[j-2+a]<num)
							max=Math.max(max, arr[j-2+a]);
						else {
							next=true;
							break;
						}
					}
				}
				
				if(!next) {
					count+= num-max;
					j+=2;
				}
			}
			
			System.out.println("#"+(i+1)+" "+count);
		}

	}

}
