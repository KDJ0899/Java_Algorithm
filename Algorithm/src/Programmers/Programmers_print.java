package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @Package : OurAlgorism_December
 * @FileName : Programmers_print.java
 * @Author : KIM DONGJIN
 * @date : 2019. 1. 23. 
 *
 */
public class Programmers_print {
	
	 public static int solution(int[] priorities, int location) {
	        int answer = 0;
	        
	        List<Integer> list=new ArrayList<>();
	        List<Integer> numList=new ArrayList<>();
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        
	        
	        for(int i=0; i<priorities.length; i++) {
	        	numList.add(priorities[i]);
	        	if((map.get(priorities[i])==null)) {
	        		list.add(priorities[i]);
	        		map.put(priorities[i], 1);
	        	}
	        	else {
	        		map.put(priorities[i], map.get(priorities[i])+1);
	        	}
	        }
	        
	        Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
	        	
			});
	        System.out.println(map);
	        while(location>-1) {
	        	location--;
	        	
	        	if(list.get(0)==numList.get(0)) {
	        		
	        		if(map.get(list.get(0))==1) {
	        			map.remove(list.get(0));
	        			list.remove(0);
	        		}
	        		else {
	        			map.put(list.get(0),map.get(list.get(0))-1 );
	        		}
	        		numList.remove(0);
	        		answer++;
	        	}
	        	
	        	else {
	        		numList.add(numList.get(0));
	        		numList.remove(0);
	        		if(location==-1)
	        			location=numList.size()-1;
	        	}
	        	
	        }
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(solution(new int[] {1,1,9,9,1,1},1));
	 }

}
