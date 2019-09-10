package OurAlgorism_January;

import java.util.Scanner;
/**
 * 
 * 18.01.27 pm.11:10 인도 태일이형과 책 페이지에 들어가는 숫자 구하기(실패)
 * 
 * @Package : OurAlgorism_January
 * @FileName : book_page.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 27. 
 *
 */
public class book_page {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int[] arr=new int[10];
		int[] num=new int[100];
		int k=n,up=0;
		while(true) {
			if(k/10==0) {
				num[up]=k%10;
				break;
			}
			else{
				num[up]=9;
				k/=10;
			}
			up++;
		}
		System.out.println(up);
			for(int i=0;i<=up;i++) {
				if(i==0)
					for(int a=1;a<=num[i];a++) {
						arr[a]+=Math.pow(10, i);
						}
				else {
					for(int j=1;j<num[i];j++) {
						arr[j]+=(int)Math.pow(10, i);
					}
					if(num[i]>1)
						for(int j=1;j<=9;j++){
							arr[j]+=num[i]-1;
						}
					for(int j=1;j<=num[i];j++)
						arr[0]++;
				}
			}
		for(int i=1;i<=n%10*up;i++) {
			arr[i]++;
			arr[num[up]]++;
		}
		for(int i=0;i<10;i++)
			System.out.print(arr[i]+" ");
	}
}
