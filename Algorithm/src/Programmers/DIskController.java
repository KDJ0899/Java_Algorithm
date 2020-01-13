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
  * @Comment : 프로그래머스 디스크 컨트롤러 문제 풀이 완료
 */
public class DIskController {
	
	 public static int solution(int[][] jobs) {
	        int answer = 0;
	        
	        Map<Integer, List<Integer>> requestTimeList = new HashMap<Integer, List<Integer>>();
	    	List<Integer> requestTimes = new ArrayList<Integer>();
	    	List<Integer> list, requestedJob =new ArrayList<Integer>();

	    	int requestTime,time = 0,remaingTime=0;

	        
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
	        
	        for(int key : requestTimeList.keySet()) {
	        	requestTimes.add(key);
	        }
	        
	        requestTimes.sort(null);
	        
	        for(int i=0; i<requestTimes.size()-1; i++) {
	        	requestTime = requestTimes.get(i);
	        	list = requestTimeList.get(requestTime);
	        	requestedJob.addAll(list);
	        	requestedJob.sort(null);
	        	
	        	if(remaingTime!=0) {
	        		requestedJob.add(0, remaingTime);
	        		remaingTime=0;
	        	}
	        	
	        	if(requestTime + requestedJob.get(0)<requestTimes.get(i+1)) {
	        		time=0;
	        		while(!requestedJob.isEmpty()&&requestTime+time+requestedJob.get(0)<=requestTimes.get(i+1)) {
		        		answer+=requestedJob.get(0)*requestedJob.size();
		        		time += requestedJob.get(0);
		        		requestedJob.remove(0);
	        		}
	        		
	        		if(!requestedJob.isEmpty()) {
	        			answer+=(requestTimes.get(i+1)-time-requestTime)*requestedJob.size();
	        			remaingTime = requestedJob.get(0) - (requestTimes.get(i+1)-time-requestTime);
	        			requestedJob.remove(0);
	        		}
	       
	        	}
	        	else {
	        		answer+= (requestTimes.get(i+1)-requestTimes.get(i))*requestedJob.size();
	        		remaingTime = requestedJob.get(0)-(requestTimes.get(i+1)-requestTimes.get(i));
	        		requestedJob.remove(0);
	        		
	        	}
	        	
	        }
	        
	        requestTime = requestTimes.get(requestTimes.size()-1);
        	list = requestTimeList.get(requestTime);
        	requestedJob.addAll(list);
        	requestedJob.sort(null);
        	
        	if(remaingTime!=0) {
        		requestedJob.add(0, remaingTime);
        		remaingTime=0;
        	}
        	
        	while(!requestedJob.isEmpty()) {
        		answer += requestedJob.get(0)*requestedJob.size();
        		requestedJob.remove(0);
        	}

	        return answer/jobs.length;
	    }

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,3},{1,2},{4,5},{12,6}}));
		System.out.println(solution(new int[][] {{0,3},{1,9},{500,6}}));
		System.out.println(solution(new int[][] {{0,5},{1,2},{5,5}}));
		System.out.println(solution(new int[][] {{0,3},{1,9},{2,6},{4,3}}));
		System.out.println(solution(new int[][] {{0,9},{0,4},{0,5},{0,7},{0,3}}));
		System.out.println(solution(new int[][] {{1,9},{1,4},{1,5},{1,7},{1,3}}));
		System.out.println(solution(new int[][] {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}}));
		
	
	}

}
