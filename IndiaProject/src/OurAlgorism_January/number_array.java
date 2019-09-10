package OurAlgorism_January;

import java.util.Scanner;

/**
 * 숫자 연속으로 뽑기(은하문제)
 * 
 * @Package : OurAlgorism_January
 * @FileName : number_array.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 12. 
 *
 */
public class number_array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int sw=0,k=1;
		
		for(int i=1;i<=2*n-1;i++) {
			if(sw==0) {
				for(int j=0;j<k;j++)
					System.out.print(k);
				if(k==n) {
					sw=1;
					k--;
				}
				k++;
			}
			else {
				k--;
				for(int j=k;j>0;j--)
					System.out.print(k);
			}
		}		
	}
}
