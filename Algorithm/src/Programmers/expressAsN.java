package Programmers;

/**
  * @FileName : expressAsN.java
  * @Project : Algorithm
  * @Date : 2019. 3. 13. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적 계획법 - N으로 표현 문제 (완로)
 */
public class expressAsN {
	
	static int minCount=9,n, goalNum;

	public static int solution(int N, int number) {
        goalNum=number;
        n=N;
        recursion(0,0);
        
        return (minCount==9)? -1 : minCount;
    }
	
	public static void recursion(int nowVal, int count) {
		int nowNum=0;
		
		if(nowVal==goalNum) {
			minCount=Math.min(count, minCount);
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(count>=minCount) 
				return;
			nowNum=Integer.parseInt(nowNum+""+n);
			count++;
			recursion(nowVal+nowNum,count);
			recursion(nowVal-nowNum,count);
			recursion(nowVal*nowNum,count);
			recursion(nowVal/nowNum,count);

		}
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution(5,12));
		System.out.println(solution(2,11));
	}

}
