package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
  * @FileName : BlackJack.java
  * @Project : Algorithm
  * @Date : 2020. 10. 2. 
  * @Author : Kim DongJin
  * @Comment : 백준 2798번 블랙잭 문제 풀이완료.
 */
public class BlackJack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), M = sc.nextInt(), answer = 0, sum;
		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(cards);
		
		loop : for(int i=N-1; i>1; i--) {
			for(int j = i-1; j>0; j--) {
				sum = cards[i] + cards[j];
				if(sum + cards[j-1] <=M) {
					answer = Math.max(answer, sum + cards[j-1]);
				}
				for(int x = j-2; x>=0; x--) {
					if(sum + cards[x] == M) {
						answer = M;
						break loop;
					} else if (sum + cards[x] < M) {
						answer = Math.max(answer, sum+cards[x]);
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
