package MCC_180202;

import java.util.Scanner;

public class Smith_number {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=n,sumDit=0,sumFac=0,prime=0,s;
		int arr[]=new int[100];
	
		while(true) {
			if(k==0)
				break;
			sumDit+=k%10;
			k/=10;
		}
		k=n;
		while(true) {
			for(int i=2;i<=k;i++) {
				if(k%i==0) {
					if(i>9) {
						s=i;
						while(true) {
							if(s==0)
								break;
							sumFac+=s%10;
							s/=10;
							}
						k/=i;
						}
					else {
						sumFac+=i;
						k/=i;
					}
				}
			}
			if(k==1)
				break;
		}
		if(sumDit==sumFac) 
			System.out.println("SMITH Number");
		else 
			System.out.println("NOT SMITH Number");
	}

}
