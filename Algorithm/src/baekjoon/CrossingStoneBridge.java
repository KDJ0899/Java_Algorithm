package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : CrossingStoneBridge.java
  * @Project : Algorithm
  * @Date : 2020. 9. 24. 
  * @Author : Kim DongJin
  * @Comment : 백준 2602 돌다리 건너기 문제 풀이 완료
 */
public class CrossingStoneBridge {
	
	static 	char[] angelBridge, devilBridge, words;
	static int[][][] dp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine(), angel = sc.nextLine(), devil = sc.nextLine();
		
		words = word.toCharArray();
		angelBridge = angel.toCharArray();
		devilBridge = devil.toCharArray();
		dp = new int[angelBridge.length][words.length][2];
		

		System.out.println(crossBridge(0, 0, 0) + crossBridge(0, 0, 1));
		
		sc.close();
	}
	
	public static int crossBridge(int wordIndex, int bridgeIndex , int angel) {
		
		if(words.length == wordIndex) {
			return 1;
		}
		if(bridgeIndex >= angelBridge.length) {
			return 0;
		}
		
		if (dp[bridgeIndex][wordIndex][angel] > 0) {
			return dp[bridgeIndex][wordIndex][angel];
		}
		
		int count = 0;
		char word = words[wordIndex];
		if(angel==0) {
			for(int i=bridgeIndex; i<angelBridge.length; i++) {
				if(word == angelBridge[i])
					count += crossBridge(wordIndex+1, i+1, 1);
			}
		}else {
			for(int i=bridgeIndex; i<devilBridge.length; i++) {
				if(word == devilBridge[i])
					count += crossBridge(wordIndex+1, i+1, 0);
			}
		}
		
		return dp[bridgeIndex][wordIndex][angel] = count;
	}

}
