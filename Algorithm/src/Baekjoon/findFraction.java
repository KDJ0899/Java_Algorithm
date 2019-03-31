/**
 *
 */
package Baekjoon;

import java.util.Scanner;

/**
  * @FileName : findFraction.java
  * @Project : Algorithm
  * @Date : 2018. 4. 31. 
  * @Author : Kim DongJin
  * @Comment :백준 알고리즘 1193 분수찾기 문제 풀이 
 */
public class findFraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i,x,a,b,o;
		Scanner n=new Scanner(System.in);
		x=n.nextInt();
		o=1;
		for(i=0;i<=250000;i++)
		{
			o=o+4*i;
			if(x<=o)
				break;
		}
		a=b=i+1;
		while(x!=1) {
		for(;b>1;b--) {
				if(x==o)
					break;
				a++;
				o--;
			}
		if(x!=o) {
			o--;
			if(x==o)
				a--;
		}
		if(x==o)
			break;
		a--;
		for(;a>1;a--) {
				if(x==o)
					break;
				b++;
				o--;
			}
		if(x!=o) {
			o--;
			if(x==o)
				b--;
		}
		if(x==o)
			break;
		b--;
		
		while(x!=o) {
			a++;
			b--;
			o--;
		}
		break;
		}
		System.out.println(a+"/"+b);
	}
}
