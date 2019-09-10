package MCC_180124;

import java.util.Scanner;

public class As_primenumber_upgrade {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number:");
		int n=sc.nextInt();
		int count=0;
		for(int i=2;i<=n;i++) {
			int point=0;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					point++;
					break;
				}
			}
			if(point==0) {
				System.out.print(i+", ");
				count++;
				if(count==10) {
					System.out.println();
					count=0;
				}
			}
		}
		sc.close();
	}
}

