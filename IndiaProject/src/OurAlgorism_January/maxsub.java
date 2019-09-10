package OurAlgorism_January;

import java.util.Scanner;

/**
 * 최대공약수,최소공배수
 * 
 * @Package : OurAlgorism_January
 * @FileName : maxsub.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 25. 
 *
 */
public class maxsub {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("두수를 입력하시요.");
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k,a=n,b=m;
		if(n>m) {
			k=n;
			n=m;
			m=k;
		}
		while(true) {
			if(n%m==0) 
				break;
			else {
				k=n%m;
				n=m;
				m=k;
			}
		}
		System.out.println("최대 공약수는"+m);
		System.out.println("최소 공배수는"+(a/m)*(b/m)*m);
	}
}
