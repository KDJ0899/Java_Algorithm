package MCC_180129;

import java.util.Scanner;

public class make_triangle {
	static class made{
		public void right_angle_triangle(int n) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=i;j++)
					System.out.print(j);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		made num=new made();
		num.right_angle_triangle(n);
		
		sc.close();
	}
}


