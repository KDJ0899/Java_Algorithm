package MCC_180123;

import java.util.Scanner;

public class Fibonacci {
	public static int fibon(int n) {
		if (n==1)
			return 0;
		else if(n==2)
			return 1;
		else
			return fibon(n-1)+fibon(n-2);	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print(fibon(i));
			if(i<n)
				System.out.print(",");
		}
		sc.close();
	}
}
