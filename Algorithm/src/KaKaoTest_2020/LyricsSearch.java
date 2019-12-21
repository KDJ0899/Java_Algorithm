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
  * @Comment : 2020카카오 가사 검색 문제.효율성에서 하나만 만족 못함(트리로 만들어야 함).
 */
public class LyricsSearch {

	public static int[] solution(String[] words, String[] queries) {
		
		int[] answer = new int[queries.length];
	        
        Map<Integer,List<String>> map = new HashMap<Integer, List<String>>();
        Map<String, Integer> contain = new HashMap<String, Integer>();
        
        for(int i=0; i<words.length;i++) { // 키워드 길이에 따라 분류.
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
    		
    		if(contain.containsKey(target)) //중복된 키워드는 저장된 횟수를 넣음.
    			answer[i]=contain.get(target);
    		else {
	    		if(map.containsKey(length)) { // 키워드와 가사의 길이가 맞는 것이 있을때만 실행.
	    			List<String> list = map.get(length);
					if(start==0) {
						if(end==length-1) //키워드가 전부 물음표일시.
							for(int j=0; j<list.size(); j++) 
				    			answer[i]++;
						else {// 물음표가 앞에서 부터.
							piece = target.substring(end+1,length);
							for(int j=0; j<list.size(); j++) {
				    			if(piece.equals(list.get(j).substring(end+1,length))) 
				    				answer[i]++;		
							}
						}
					}
					
					else { // 물음표가 뒤에서 부터.
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
