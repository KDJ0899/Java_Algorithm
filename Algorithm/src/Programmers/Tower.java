package Programmers;
/**
 * 
  * @FileName : Top.java
  * @Project : Algorithm
  * @Date : 2020. 1. 8. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 스택 탑 문제 풀이 완료
 */
public class Tower {
	
	 public int[] solution(int[] heights) {
	  
	        int numOfTower = heights.length;
	        int[] answer = new int[numOfTower];
	        int towerH;
	        
	        for(int i=numOfTower - 1; i>=0; i--) {
	        	towerH = heights[i];
	        	for(int j=i-1; j>=0; j--) {
	        		if(heights[j]>towerH) {
	        			answer[i] = j+1;
	        			break;
	        		}
	        	}
	        }
	        
	        return answer;
	    }


}
