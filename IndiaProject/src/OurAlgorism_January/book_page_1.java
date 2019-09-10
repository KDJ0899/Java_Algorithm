package OurAlgorism_January;

import java.util.Scanner;
/**
 * //18.01.27 pm.11:10 인도 태일이형과 책 페이지에 들어가는 숫자 구하기(실패)
 * 
 * @Package : OurAlgorism_January
 * @FileName : book_page_1.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 27. 
 *
 */
public class book_page_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int[] arr=new int[10];
		
		int up=1,k=0;
		
		for(int i=1;i<=n;i++) {
			arr[i%10]++;
			if(i>((int)Math.pow(10, up+1)-1))
				up++;
			if(i>(int)Math.pow(10, up)-1) {
				arr[i/(int)Math.pow(10, up)]++;
				k=i/10;
			}
		}
		for(int i=0;i<9;i++)
			System.out.println(arr[i]);
		
	}

}
