package MCC_180129;

import java.util.Scanner;

public class TwinPrimenumber {
	static class TwinPri{
		int num;

		public TwinPri(int num) {
			this.num=num;
		}
		public TwinPri() {}
		
		public void print_TwinPrimebumber() {
			int n=2,prime = 0,cont=0;
			for(int i=2;i<=num;i++) {
				for(int j=2;j<i;j++) {
					prime=0;
				
					if(i%j==0) {
						prime=1;
						break;
					}
				}
				if(prime==0) {
					if(i-n==2) {
						System.out.print("("+n+","+i+") ");
						cont++;
						}
					if(cont==5) {
						cont=0;
						System.out.println();
					}
					n=i;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		TwinPri primenum=new TwinPri(n);
		primenum.print_TwinPrimebumber();
		sc.close();
	}
}
