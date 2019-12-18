package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : SteppingLeg.java
  * @Project : Algorithm
  * @Date : 2019. 12. 18. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 징검다리 문제 (진행중)
 */
public class SteppingLeg {
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int length = rocks.length, min = Integer.MAX_VALUE, point = 0;
        Arrays.sort(rocks);
        
        int[] betweens = new int[length+1];
        boolean[] removed = new boolean[length+1];

        betweens[0]=rocks[0];
        
        
        for(int i=1; i<length; i++) {
        	betweens[i]=rocks[i]-rocks[i-1];
        }
        
        betweens[length] = distance - rocks[length-1];
        
        for(int i=0; i<n; i++) {
        	min = Integer.MAX_VALUE;
        	for(int j=0; j<betweens.length; j++) {
        		if(betweens[j]<min) {
        			point=j;
        			min = betweens[j];
        		}
        		else if(betweens[j]==min) {
        			point = compare(point, j, betweens);
        			min = betweens[point];
        		}
        			
        	}
        	
        	betweens[point] = Integer.MAX_VALUE-1;
        	
        	if(point==0)
        		betweens[point+1] = min +betweens[point+1];
        	else if(point == length)
        		betweens[point-1] = min + betweens[point-1];
        	else if(betweens[point+1]>betweens[point-1])
        		betweens[point-1] = min + betweens[point-1];
        	else
        		betweens[point+1] = min + betweens[point+1];
      
        }
        
        Arrays.sort(betweens);
        
        answer = betweens[0];
        
        
        return answer;
    }
    
    public static int compare(int a, int b,int[] betweens) {
    	
    	int Min = Integer.MAX_VALUE;
    	int answer = a;
    	
    	if(a==0)
    		Min = betweens[a]+betweens[a+1];
    	else {
    		Min = betweens[a]+betweens[a-1];
    		
    		if(Min>betweens[a]+betweens[a+1])
    			Min = betweens[a]+betweens[a+1];
    	}

    	if(b==betweens.length-1) {
    		if(Min>betweens[b]+betweens[b-1]) {
        		Min = betweens[b]+betweens[b-1];
        		return b;
    		}
    	}
    	else {
    		if(Min>betweens[b]+betweens[b+1]) {
        		Min = betweens[b]+betweens[b+1];
        		return b;
    		}
        	
        	if(Min>betweens[b]+betweens[b-1]) {
        		Min = betweens[b]+betweens[b-1];
        		return b;
        	}
    	}
    	
    	return answer;

    }
    
	
	public static void main(String[] args) {
		solution(25, new int[] {2, 14, 11, 21, 17}, 2);
	}

}
