package MCC_180124;

import java.util.Scanner;

public class homework {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int sum=1,i,j,cont=0;
		System.out.println("niven numbers are");
		for(i=1;i<=n;i++) {
			sum=0;
			j=i;
			while(true) {
				sum+=j%10;
				j/=10;
				
				if(j==0)
					break;
				}
			if(i%sum==0) {
				System.out.print(i+"  ");
				cont++;
			}
			if(cont==10) {
				System.out.println();
				cont=0;
			}
		}
		sc.close();
	}
}
