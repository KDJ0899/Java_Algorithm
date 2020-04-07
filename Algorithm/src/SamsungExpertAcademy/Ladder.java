package SamsungExpertAcademy;

import java.util.Scanner;
/**
 * 
  * @FileName : Ladder.java
  * @Project : Algorithm
  * @Date : 2020. 4. 7. 
  * @Author : Kim DongJin
  * @Comment : SW Expert Academy D4 Laader1문제 풀이 완료.
 */
public class Ladder {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 1, num, x = 0, y = 99;
		int[][] ladder = new int[100][100];

		for (int test_case = 1; test_case <= T; test_case++) {
			num = sc.nextInt();
			x = 0;
			y = 99;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();

					if (ladder[i][j] == 2)
						x = j;
				}
			}
			while (y != 0) {
				if(x-1>=0 && ladder[y][x-1]==1)
					x = left(x-1, y, ladder);
				else if(x+1<100 && ladder[y][x+1] == 1)
					x = right(x+1, y, ladder);
				y--;
				System.out.println(y+"  "+x);
			}

			System.out.println("#" + test_case + " " + x);
		}
	}

	public static int left(int x, int y, int[][] ladder) {
		while (ladder[y][x] == 1) {
			if (x - 1 < 0)
				return x;
			x--;
		}
		return x + 1;
	}

	public static int right(int x, int y, int[][] ladder) {
		while (ladder[y][x] ==1) {
			if (x + 1 > 99)
				return x;
			x++;
		}
		return x - 1;
	}

}
