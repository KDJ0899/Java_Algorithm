package OurAlgorism_January;
import java.util.Scanner;

/**
 * 다이아모양으로 별 찍기
 * 
 * @Package : OurAlgorism_January
 * @FileName : dia.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 22. 
 *
 */
public class dia {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cen=n/2,sw=0,k=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=cen+1+k;j++) {
					if(j>=cen+1-k)
						System.out.print("*");
					else
						System.out.print(" ");
			}
			if(k==cen)
				sw=1;
			if(sw==0)
				k++;
			if(sw==1)
				k--;
			System.out.println();
		}
	}
}
				
		

	


