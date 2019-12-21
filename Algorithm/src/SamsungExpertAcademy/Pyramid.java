package SamsungExpertAcademy;

import java.util.Scanner;

/**
 * 
  * @FileName : Pyramid.java
  * @Project : Algorithm
  * @Date : 2019. 12. 16. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 4112. D5 이상한 피라미드 탐험 (완료)
 */
public class Pyramid {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T,a,b,i,aX=0,bX=0,aY,bY,tmp1,tmp2,answer,diff;
		T=sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			a = sc.nextInt();
			b = sc.nextInt();
			if(a>b) {
				tmp1 =a;
				a=b;
				b=tmp1;
			}
			aY = 0;
			bY = 0;
			i=1;
			
			while(true){
				tmp1 = i*(i-1)/2+1;
				tmp2 = i*(i+1)/2;
				
				if(aY!=0&&bY!=0)
					break;
				
				if(tmp1 <=a&&tmp2>=a) {
					aY = i;
					aX = a-tmp1;
				}
				
				if(tmp1 <=b&&tmp2>=b) {
					bY = i;
					bX = b-tmp1;
				}
				
				i++;
				
				
			}
			
			if(aY==bY) {
				answer = Math.abs(a-b);
			}
			else {
			
				diff = bY-aY;
				
				if(aX>=bX-diff&&aX<=bX)
					answer = diff;
				else if(aX<bX-diff) {
					answer = diff+bX-diff-aX;
				}
				else
					answer = diff+aX-bX;
						
				
					
			}
			
			System.out.println("#"+test_case+" "+ answer);
			
			

		}
	}

}
