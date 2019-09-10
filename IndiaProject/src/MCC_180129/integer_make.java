package MCC_180129;

import java.util.Scanner;

public class integer_make {
	static class integer{
		int num;
		
		public integer() {}
		public integer(int num) {
			this.num=num;
		}
		public void print() {
			for(int i=1;i<=num;i++) {
				for(int j=0;j<=num;j++)
					System.out.println(i+"*"+j+"= "+i*j);
			}
		}	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		integer x=new integer(n);
		x.print();
		sc.close();
	}
}
