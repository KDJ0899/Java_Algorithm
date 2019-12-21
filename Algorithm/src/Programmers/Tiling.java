package Programmers;

/**
 * 
  * @FileName : Tiling.java
  * @Project : Algorithm
  * @Date : 2019. 12. 13. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 2*n 타일링 문제 (완료)
  * 		DP문제 
 */
public class Tiling {
	
	 
	public static int solution(int n) {
	      int[] arr = new int[n + 1];
	      arr[1] = 1;
	      arr[2] = 2;
	      for(int i = 3; i < n + 1; i++){
	          arr[i] = arr[i - 1] % 1000000007 + arr[i - 2] % 1000000007;
	      }

	      return arr[n] % 1000000007;
	  }
	

	public static void main(String[] args) {
		System.out.println(solution(4));

	}

}
