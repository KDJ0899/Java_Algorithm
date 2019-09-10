package MCC_180124;

import java.util.Scanner;

public class As_primenumber {
	public static void main(String[] args) {
		Scanner  sc=new Scanner(System.in);
		int input=sc.nextInt();
		int count=0;
		
		for(int i=2;i<input;i++) {
			if(input%i==0) {
				System.out.println("not prime number");
				count++;
				break;
			}
		}
		if(count==0) {
			System.out.println("prime number");
		}
		sc.close();
	}
}
