package OurAlgorism_April;

import java.util.Scanner;

/**
 * 2018 카카오 코딩 테스트 2번 문제 다트게임.
 * 참고 http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * 
 * @Package : OurAlgorism_April
 * @FileName : kakaoExam_2018_2.java
 * @Author : KIM DONGJIN
 * @date : 2018. 4. 29. 
 *
 */
public class kakaoExam_2018_2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String game=sc.nextLine();
		char[] score;
		int sum=0,Num=0,lastNum=0;
		score=game.toCharArray();
		for(int i=0;i<score.length;i++) {
			if(score[i]>='0'&&score[i]<='9') {
				if(score[i+1]=='0') {
					Num=10;
					i++;
				}
				else {
					Num=score[i]-48;
				}
				continue;
			}
			else if(score[i]=='d') {
				Num=(int) Math.pow(Num, 2);
			}
			else if(score[i]=='t') {
				Num=(int) Math.pow(Num, 3);
			}
			if(i+1<score.length&&score[i+1]=='*') {
				i++;
				sum+=lastNum+Num*2;
				lastNum=Num*2;
				continue;
			}
			else if(i+1<score.length&&score[i+1]=='#') {
				i++;
				sum-=Num;
				lastNum=-Num;
				continue;
			}
			sum+=Num;
			lastNum=Num;
		}
		System.out.println(sum);
	}
}
