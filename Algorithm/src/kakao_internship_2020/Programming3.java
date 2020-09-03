package kakao_internship_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 
  * @FileName : Programming3.java
  * @Project : Algorithm
  * @Date : 2020. 5. 23. 
  * @Author : Kim DongJin
  * @Comment : 진열장, 모든 보석을 사는 조건에서 최소 갯수 구하기. 투포인터
 */
public class Programming3 {
	
	public static int[] solution(String[] gems) {
        int[] answer = {};
        
        Map<String, Queue<Integer>> gemBox = new HashMap<String, Queue<Integer>>();
        Map<String, Integer> nowGemBox = new HashMap<String, Integer>();
        String gem;
        int gemNum , x = 0, y;
        
        for(int i=0; i<gems.length; i++) {
        	gem = gems[i];
        	
        	if(!gemBox.containsKey(gem))
        		gemBox.put(gem, new LinkedList<Integer>());
        	
        	gemBox.get(gem).add(i);
        }
        
        if(gemBox.size() ==1 )
        	answer = new int[] {1,1};
        
        else {
        	for(int i=gemBox.size(); i<gems.length; i++) {
        		for(int j=0; j< gems.length - i; j++) {
        			
        		}
        	}
        }
        
        return answer;
    }
	
	public static int[] solution2(String[] gems) {
		int[] answer = {-1, -1};
		Set<String> gemType = new HashSet<String>();
		Map<String,Integer> gemBox = new HashMap<String, Integer>();
        String gem;
        int x = 0, y = 0;
        
        for(int i=0; i<gems.length; i++) {
        	gem = gems[i];
        	
        	gemType.add(gem);
        }
        
        while(y<gems.length&&x<gems.length) {
        	gem = gems[y];
        	
        	if(!gemBox.containsKey(gem)) 
        		gemBox.put(gem, 0);
        	
        	gemBox.put(gem, gemBox.get(gem)+1);
        	
        	if(gemBox.keySet().size() == gemType.size()) {
        		
        		if(answer[0] == -1 || answer[1]-answer[0]>y - x) {
        			answer[0] = x;
        			answer[1] = y;
        			
        			if(y-x+1 == gemType.size())
        				break;
        		}
        		
        		update(gemBox, gems[x]);
    			x++;
        	}
        	else {
        		
        		if(gems[x].equals(gems[y])&&y!=0) {
            		update(gemBox, gems[x]);
            		x++;
            	}
        		
        		y++;
        		
        	}
        }
        
        return answer;
	}
	
	public static void update(Map<String,Integer> gemBox, String gem) {
		gemBox.put(gem, gemBox.get(gem)-1);
		
		if(gemBox.get(gem)==0)
			gemBox.remove(gem);
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution2(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
		System.out.println(Arrays.toString(solution2(new String[] {"DIA", "DIA",  "DIA", "RUBY", "RUBY", "EMERALD", "SAPPHIRE", "DIA"})));
		System.out.println(Arrays.toString(solution2(new String[] {"DIA", "DIA", "RUBY" , "DIA", "RUBY", "RUBY", "EMERALD", "SAPPHIRE"})));
		System.out.println(Arrays.toString(solution2(new String[] {"DIA", "DIA","RUBY","RUBY", "EMERALD"})));
	}

}
