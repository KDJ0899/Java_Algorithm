package OurAlgorism_February;

import java.util.Scanner;
/**
 * 유진수 백준 1356번 문제
 * 
 * @Package : OurAlgorism_February
 * @FileName : twoDigitNumber.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class twoDigitNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();//n�� �Է¹���
		int i=0,sum1,sum2;
		boolean yes=false;
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
				yes=true;
				break;
			}
		}
		if(yes) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
