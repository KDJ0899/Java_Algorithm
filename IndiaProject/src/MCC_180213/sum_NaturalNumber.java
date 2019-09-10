/**
 * @Summary   : 
 * @Package : MCC_180213
 * @FileName : sum_NaturalNumber.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 13.  
 * 
 */
package MCC_180213;

import java.util.Scanner;

/**
 * 주어진 숫자를 만들 수 있는 연속되는 숫자들구하기
 * 
 * @Package : MCC_180213
 * @FileName : sum_NaturalNumber.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 13. 
 * 
 */
interface number{
	public static void sum(int n) {}
}
class natural_number implements number{
	public static void sum(int n) {
		int sum=0;
		for(int i=1;i<=n/2+1;i++) {
			sum=0;
			for(int j=i;j<=n/2+1;j++){
				sum+=j;
				if(sum==n) {
					for(int a=i;a<=j;a++)
						System.out.print(a+" ");
					System.out.println();
					break;
				}
				else if(sum>n) {
					break;
				}
			}
		}
	}
}
public class sum_NaturalNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		natural_number obj=new natural_number();
		obj.sum(n);
	}

}
