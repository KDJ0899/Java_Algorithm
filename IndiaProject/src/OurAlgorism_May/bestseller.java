package OurAlgorism_May;

import java.awt.List;
import java.util.Scanner;

/**
 * 백준 1302번 베스트셀러문제 
 * 
 * @Package : OurAlgorism_May
 * @FileName : bestseller.java
 * @Author : KIM DONGJIN
 * @date : 2018. 5. 19. 
 *
 */
public class bestseller {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cont=0,max=0;
		boolean dupl=false;
		String book;
		String sell[]=new String[n];
		List Bestsell=new List();
		int count[]=new int[n];
		for(int i=0;i<n;i++) {
			book=sc.next();
			if(i==0) {
				sell[cont]=book;
				count[cont]++;
				cont++;
			}
			else {
				dupl=false;
				for(int j=0;j<cont;j++) {
					if(sell[i]==book) {
						count[cont]++;
						dupl=true;
						break;
					}
				}
				if(dupl==false) {
					sell[cont]=book;
					count[cont]++;
				}
			}
		}
		for(int i=0;i<cont;i++) {
			if(count[i]>max) {
				max=count[i];
			}
		}
		for(int i=0;i<cont;i++) {
			if(count[i]==max) {
				Bestsell.add(sell[cont]);
			}
		}
		

	}

}
