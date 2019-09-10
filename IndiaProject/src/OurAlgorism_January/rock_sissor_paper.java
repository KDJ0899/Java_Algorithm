package OurAlgorism_January;
import java.util.Scanner;

/**
 * 가위바위보
 * 
 * @Package : OurAlgorism_January
 * @FileName : rock_sissor_paper.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 26. 
 *
 */
public class rock_sissor_paper {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int stair=sc.nextInt();
		int x=0,y=0,win=0,a,b,who=2;
		
		while(true) {
			a=(int) (Math.random()*3+1);
			b=(int) (Math.random()*3+1);//1= 가위,2= 묵,3= 보
			
			if(a==b) {
				who=2;
			}
			else if(a>b){
				if(a==3&&b==1) {//y가 가위로 이긴경우
					who=1;
					win=2;
					y+=win;
				}
				else if(a==3) {//x가 보자기로 이긴경우
					who=0;
					win=5;
					x+=win;
				}
				else {//x가 묵으로 이긴경우
					who=0;
					win=1;
					x+=win;
				}
			}
			else {	
				if(b==3&&a==1) {//x가 가위로 이긴경우
					who=0;
					win=2;
					x+=win;
				}
				else if(b==3) {//y가 보자기로 이긴경우
					who=1;
					win=5;
					y+=win;
				}
				else {//x가 묵으로 이긴경우
					who=1;
					win=1;
					y+=win;
				}
				
			}
			switch(who) {
			case 0:
				if(win==1) 
					System.out.println("x가 묵으로 이겼습니다.+1칸");
				else if(win==2) 
					System.out.println("x가 가위로 이겼습니다.+2칸");
				else
					System.out.println("x가 보자기로 이겼습니다.+5칸");
				break;
			case 1:
				if(win==1) 
					System.out.println("y가 묵으로 이겼습니다.+1칸");
				else if(win==2) 
					System.out.println("y가 가위로 이겼습니다.+2칸");
				else
					System.out.println("y가 보자기로 이겼습니다.+5칸");
				break;
			default:
				System.out.println("비겼습니다.");
			}
			if(x>=stair) {
				System.out.println("x가 계단을 다 올랐습니다. 우승!!!~~!!");
				break;
			}
			else if(y>=stair) {
				System.out.println("Y가 계단을 다 올랐습니다. 우승!!~~!!~~!!~~");
				break;
			}
			System.out.println(">>>현재 계단 x는 "+x+"칸 y는 "+y+"칸");
		}
	}

}
