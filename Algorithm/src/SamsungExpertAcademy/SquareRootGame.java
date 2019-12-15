package SamsungExpertAcademy;

import java.util.Scanner;

/**
 * 
  * @FileName : SquareRootGame.java
  * @Project : Algorithm
  * @Date : 2019. 12. 15. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 6782. D5 현주가 좋아하는 제곱근 놀이
 */
public class SquareRootGame {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int T = sc.nextInt();
		long n,count,s,p;
		
		for(int i=0; i<T; i++) {
			n = sc.nextLong();
			count = 0; 
			
			while(true) {
				
				if(n==2)
					break;
				
				s =(long) Math.sqrt(n);
				
				p = (long) Math.pow(s, 2);
				
				if(p!=n) {
					p = (long) Math.pow(s+1, 2);
					count+=p-n+1;
					n=(long) Math.sqrt(p);
				}
				else {
					count++; 
					n=s;
				}
				
			}
			System.out.println("#"+(i+1)+" "+count);
			
		}
		
		sc.close();

	}

}
