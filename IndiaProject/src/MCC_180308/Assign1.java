package MCC_180308;

import java.util.Scanner;

/**
 * 
 * 
 * @Package : MCC_180308
 * @FileName : Assign1.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 8. 
 *
 */
public class Assign1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] prime=new int[100];
		int a=0;
		boolean prim;
		if(n<10||n>49) {
			System.out.println("Invalid Input. Number out of range");
			return;
		}
		if(n%2==1) {
			System.out.println("Invalid Input. Number is Odd");
			return;
		}
		for(int i=2;i<=n;i++) {
			prim=true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					prim=false;
					break;
				}
			}
			if(prim==true) {
				prime[a]=i;
				a++;
			}
		}
		System.out.println("Prime pairs are: ");
		for(int i=a-1;i>=0;i--) {
			if(prime[i]+prime[i]<n)
				break;
			for(int j=i;j>=0;j--) {
				if(prime[i]+prime[j]==n)
					System.out.println(prime[i]+", "+prime[j]);
			}
		}

	}

}
