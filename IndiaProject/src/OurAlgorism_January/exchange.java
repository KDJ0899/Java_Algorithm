package OurAlgorism_January;
import java.util.Scanner;

/**
 * 거스름돈 계산기
 * 
 * @Package : OurAlgorism_January
 * @FileName : exchange.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 22. 
 *
 */
public class exchange {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int money=50000,m,sw=0;
		while(true) {
			if(n==0)
				break;
			m=n/money;
			n=n%money;
			System.out.println(money+"원권은 "+m+"개");
			if(sw==0) {
				money/=5;
				sw=1;
			}
			else {
				money/=2;
				sw=0;
			}
		}
	}
}
