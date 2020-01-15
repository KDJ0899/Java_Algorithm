/**
 *
 */
package baekjoon;

import java.util.Scanner;

/**
  * @FileName : antilogarithm.java
  * @Project : Algorithm
  * @Date : 2019. 5. 2. 
  * @Author : Kim DongJin
  * @Comment :백준 알고리즘 1356번 유진수 문제 풀이
 */
public class antilogarithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int i=0,sum1,sum2,yes=0;
		int[] arr=new int[10];
		while(n>=1) {
			arr[i]=n%10;
			n/=10;
			i++;
		}
		int[] num=new int[i];
		for(int j=0;j<num.length;j++) {
			num[j]=arr[i-1];
			i--;
		}
		for(int j=1;j<num.length;j++) {
			sum1=1;
			sum2=1;
			for(int k=0;k<j;k++) {
				sum1*=num[k];
			}
			for(int k=j;k<num.length;k++) {
				sum2*=num[k];
			}
			if(sum1==sum2) {
				yes=1;
				break;
			}
		}
		if(yes==1) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
