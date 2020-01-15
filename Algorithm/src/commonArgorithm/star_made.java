package commonArgorithm;
import java.util.Scanner;

/**
 * 별모양으로 찍기
 * 
 * @Package : OurAlgorism_January
 * @FileName : star_made.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 24. 
 *
 */
public class star_made {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
		for(int i=n;i>0;i--) {
			for(int j=i;j>0;j--)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
	
		for(int i=0;i<n;i++) {
			for(int j=n-1; j>=0;j--) {
				if(j<=i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0; j<n;j++) {
				if(j<i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
