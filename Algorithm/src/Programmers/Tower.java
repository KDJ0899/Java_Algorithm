package Programmers;

import java.util.Stack;

/**
 * 
  * @FileName : Tower.java
  * @Project : Algorithm
  * @Date : 2020. 1. 8. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 스택 탑 문제 풀이 완료
  * 			solution은 내 풀이
  * 			bestSolution 스택을 이용한 더 나은 풀이법
 */
public class Tower {
	
	int idx;
    int height;

    public Tower(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }

    @Override
    public String toString() {
        return "idx : " + idx + " height : " + height;
    }
	
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
	 
	 
	 class TowerClass {
	        int idx;
	        int height;

	        public TowerClass(int idx, int height) {
	            this.idx = idx;
	            this.height = height;
	        }

	        @Override
	        public String toString() {
	            return "idx : " + idx + " height : " + height;
	        }
	    }

	    public int[] bestSolution(int[] heights) {
	        Stack<TowerClass> st = new Stack<>();
	        int[] answer = new int[heights.length];

	        for (int i = 0; i < heights.length; i++) {
	        	TowerClass tower = new TowerClass(i + 1, heights[i]);
	            int receiveIdx = 0;

	            while (!st.isEmpty()) {
	            	TowerClass top = st.peek();

	                if (top.height > tower.height) {
	                    receiveIdx = top.idx;
	                    break;
	                }

	                st.pop();
	            }

	            st.push(tower);
	            answer[i] = receiveIdx;
	        }

	        return answer;
	    }


}
