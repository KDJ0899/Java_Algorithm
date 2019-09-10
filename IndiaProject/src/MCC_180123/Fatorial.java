package MCC_180123;

import java.util.Scanner;

public class Fatorial {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=1;
		System.out.print(n+"!=");
		for(int i=n;i>0;i--) {
			System.out.print(i);
			sum*=i;
			if(i>1)
				System.out.print("*");
		}
		System.out.println("="+sum);
		sc.close();
	}

}
