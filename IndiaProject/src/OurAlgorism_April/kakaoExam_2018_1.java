package OurAlgorism_April;

import java.util.Scanner;

/**
 * 2018 카카오 코딩 테스트 1번 문제 비밀지도.
 * 참고 http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
 * 
 * @Package : OurAlgorism_April
 * @FileName : kakaoExam_2018_1.java
 * @Author : KIM DONGJIN
 * @date : 2018. 4. 28. 
 *
 */
public class kakaoExam_2018_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt(),num,binary;
		int[][] bin1=new int[n][n];
		int[][] bin2=new int[n][n];
		String[][] road=new String[n][n];
		for(int i=0;i<n;i++) {
			num=sc.nextInt();
			for(int j=n-1;j>=0;j--) {
				binary=num%2;
				num/=2;
				bin1[i][j]=binary;
			}
		}
		for(int i=0;i<n;i++) {
			num=sc.nextInt();
			for(int j=n-1;j>=0;j--) {
				binary=num%2;
				num/=2;
				bin2[i][j]=binary;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if((bin1[i][j]|bin2[i][j])==1) {
					road[i][j]="#";
				}
				else
					road[i][j]=" ";
			}
		}
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(road[i][j]);
			}
			System.out.println();
		}
	}

}
