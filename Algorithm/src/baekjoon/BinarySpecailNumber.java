package baekjoon;

import java.util.Scanner;

/**
 * W
  * @FileName : BinarySpecailNumber.java
  * @Project : Algorithm
  * @Date : 2020. 4. 3. 
  * @Author : Kim DongJin
  * @Comment : 백준 2193 이친수 문제 풀이.
 */
public class BinarySpecailNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long zero = 0,one = 1, newZero;
		
		for(int i=1; i<N; i++) {
			newZero = one + zero;
			one = zero;
			zero = newZero;
		}
		System.out.println(one + zero);
	}

}
