package MCC_180129;

import java.util.Scanner;

public class magic_number_homework {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("m = ");
		int m=sc.nextInt();
		System.out.print("n = ");
		int n=sc.nextInt();
		int prime=0,k,sum=0,cont=0,nextline=0;
		System.out.println("THE COMPOSITE MAGIC INTEGERS ARE:");
		for(int i=m;i<=n;i++) {
			prime=0;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					prime=1;
					break;
				}		
			}
			if(prime==1) {
				k=i;
				sum=0;
				while(true) {
					sum+=k%10;
					k/=10;
					if(k==0) {
						if(sum/10!=0) {
							k=sum;
							sum=0;
							continue;
						}
						break;
					}
				}
				if(sum==1) {
					System.out.print(i+",");
					nextline++;
					cont++;
					if(nextline==10) {
						System.out.println();
						nextline=0;
					}
				}
			}
		}
		System.out.println();
		System.out.println("FREQUENCY OF COMPOSITE MAGIC INTRGERS IS:"+cont);
		sc.close();
	}
}
