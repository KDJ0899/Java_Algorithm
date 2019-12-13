package Programmers;

/**
 * 
  * @FileName : Tiling.java
  * @Project : Algorithm
  * @Date : 2019. 12. 13. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 2*n 타일링 문제!
 */
public class Tiling {
	

	static int count;
	 
	public static int solution(int n) {
	      int answer = 0;
	      
	      count = 0;
	      int one;
	      
	      for(int i = n/2; i>=0; i--) {
	    	  one = n-i*2;
	    	  search(i, one);
	      }
	      
	      answer = count;
	      
	      return answer %1000000007;
	  }
	
	public static void search(int two , int one) {
		System.out.println(two+"  "+one);
		
		if(two==0 || one ==0) {
			count++;
			return;
		}
		
		search(two-1,one);
		search(two, one-1);
		
		return;
	}
	

	public static void main(String[] args) {
		System.out.println(solution(4));

	}

}
