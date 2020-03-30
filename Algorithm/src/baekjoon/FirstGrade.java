package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 /**
  * 
   * @FileName : FirstGrade.java
   * @Project : Algorithm
   * @Date : 2020. 3. 30. 
   * @Author : Kim DongJin
   * @Comment : 백준 5557번 1학년 문제 풀이 완료. (정답률 36.260%)
  */
public class FirstGrade {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), number;
		long answer = 0, count;
		Map<Integer,Long> nowResults=new HashMap<Integer,Long>(), beforeResults = new HashMap<Integer,Long>();
		
		number = sc.nextInt();
		beforeResults.put(number, 1L);
		
		for(int i=1; i<N-1; i++) {
			number = sc.nextInt();
			nowResults = new HashMap<Integer,Long>();
			
			for(int result : beforeResults.keySet()) {
				if(result+number<=20) {
					count = 0;
					if(nowResults.containsKey(result+number))
						count = nowResults.get(result+number);
					nowResults.put(result+number,beforeResults.get(result)+count);
				}
				if(result-number>=0){
					count = 0;
					if(nowResults.containsKey(result-number))
						count = nowResults.get(result-number);
					nowResults.put(result-number,beforeResults.get(result)+count);
				}
			}
			beforeResults = nowResults;
		}
		number = sc.nextInt();
		for(int result : nowResults.keySet()) {
			if(number == result)
				answer = nowResults.get(result);
		}
		System.out.println(answer);
	}

}
