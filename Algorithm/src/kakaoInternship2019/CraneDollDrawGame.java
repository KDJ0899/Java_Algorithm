package kakaoInternship2019;

import java.util.Stack;

/**
 * 
  * @FileName : CraneDollDrawGame.java
  * @Project : Algorithm
  * @Date : 2020. 9. 3. 
  * @Author : Kim DongJin
  * @Comment :카카오 2019 겨울 인턴쉽 크레인 인형뽑기 게임 문제 풀이 완료.
 */
public class CraneDollDrawGame {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));

	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int[] heights = new int[board[0].length];
		Stack<Integer> basket = new Stack<Integer>();

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights.length; j++) {
				if (board[j][i] != 0) {
					heights[i] = j;
					break;
				}
			}
		}

		for (int i = 0; i < moves.length; i++) {
			int move = moves[i] - 1, height = heights[move], doll;
			if (height < heights.length ) {
				doll = board[height][move];
				if (!basket.empty() && doll == basket.peek()) {
					basket.pop();
					answer++;
				} else
					basket.push(doll);
				heights[move] = height + 1;
			}
		}
		
		return answer*2;
	}
}
