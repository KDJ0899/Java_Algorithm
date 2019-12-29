package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  * @FileName : DIskController.java
  * @Project : Algorithm
  * @Date : 2019. 12. 24. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 디스크 컨트롤러 문제 풀이
 */
public class DIskController {
	
	 public int solution(int[][] jobs) {
	        int answer = 0;
	        
	        Map<Integer, List<Integer>> requestTimeList = new HashMap<Integer, List<Integer>>();
	    	List<Integer> requestTimes = new ArrayList<Integer>();
	    	List<Integer> list;
	    	int requestTime;
	        
	        for(int i=0; i<jobs.length; i++) {
	        	requestTime = jobs[i][0];
	        	
	        	if(requestTimeList.containsKey(requestTime))
	        		requestTimeList.get(requestTime).add(jobs[i][1]);
	        	else {
	        		list = new ArrayList<Integer>();
	        		list.add(jobs[i][1]);
	        		requestTimeList.put(requestTime, list);
	        	}
	        }
	        
	        
	        return answer;
	    }

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		list.add(1);
		
		map.put(1,list);
		
		map.get(1).add(4);
		
		System.out.println(map.get(1).toString());
	}

}
