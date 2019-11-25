package KaKaoTest_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @FileName : LyricsSearch.java
  * @Project : Algorithm
  * @Date : 2019. 11. 25.
  * @Author : Kim DongJin
  * @Comment : 2020카카오 가사 검색 문제. 트리로 만들어야 함.
 */
public class LyricsSearch {

	public static int[] solution(String[] words, String[] queries) {
		
		int[] answer = new int[queries.length];
	        
        Map<Integer,List<String>> map = new HashMap<Integer, List<String>>();
        Map<String, Integer> contain = new HashMap<String, Integer>();
        
        for(int i=0; i<words.length;i++) {
        	int length = words[i].length();
        	if(map.containsKey(length))
        		map.get(length).add(words[i]);
        	else {
        		List<String> list = new ArrayList<String>();
        		list.add(words[i]);
        		map.put(length, list);        	
        	}
        }
        
        for(int i=0; i<queries.length; i++) {
        	String target = queries[i];
        	int start = target.indexOf('?');
    		int end = target.lastIndexOf('?');
    		int length = target.length();
    		String piece;
    		
    		if(contain.containsKey(target))
    			answer[i]=contain.get(target);
    		else {
	    		if(map.containsKey(length)) {
	    			List<String> list = map.get(length);
					if(start==0) {
						if(end==length-1) 
							for(int j=0; j<list.size(); j++) 
				    			answer[i]++;
						else {
							piece = target.substring(end+1,length);
							for(int j=0; j<list.size(); j++) {
				    			if(piece.equals(list.get(j).substring(end+1,length))) 
				    				answer[i]++;		
							}
						}
					}
					
					else {
						piece = target.substring(0,start);
						for(int j=0; j<list.size(); j++) {
							if(piece.equals(list.get(j).substring(0,start))) 
			    				answer[i]++;
						}
					}
	    		}
	    		contain.put(target, answer[i]);
    		}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"},
				new String[] {"fro??", "????o", "fr???", "fro???", "pro?"})));
	}
}
