package Programmers;

/**
  * @FileName : expressAsN.java
  * @Project : Algorithm
  * @Date : 2019. 3. 13. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적 계획법 - N으로 표현 문제
 */
public class expressAsN {
	
	static int minCount=9, n, Num;

	public static int solution(int N, int number) {
        n=N;
        Num=number;
        
        recursion(N,1);
        
        return (minCount==9)? -1 : minCount;
    }
	
	public static void recursion(int nowVal, int count) {
		System.out.println(nowVal+" "+count);
		if(nowVal!=Num && count<9 && count<minCount) {
			recursion(nowVal+n,count+1);
			recursion(nowVal-n,count+1);
			recursion(nowVal*n,count+1);
			recursion(nowVal/n,count+1);
			recursion(Integer.parseInt(nowVal+""+n),count+1);
			
		}else if(nowVal==Num)
			minCount=Math.min(count, minCount);
		
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution(5,12));
		System.out.println(solution(2,11));
	}

}
