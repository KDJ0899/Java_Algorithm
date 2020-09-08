package kakaoInternship2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
  * @FileName : Tuple.java
  * @Project : Algorithm
  * @Date : 2020. 9. 8. 
  * @Author : Kim DongJin
  * @Comment :
 */
public class Tuple {

	public static int[] solution(String s) {
		int[] answer;
		int count,i=0;
		String[] strs;
		Map<String, Integer> map = new HashMap<String, Integer>();
		strs = s.replace("{", "").replace("}", "").replace(",", " ").split(" ");
		
		for(String str : strs) {
			count = 1;
			if(map.containsKey(str)) {
				count += map.get(str);
			}
			
			map.put(str, count);
		}
		
		List<Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		
		answer = new int[map.keySet().size()];
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for(Entry<String, Integer> entry : list_entries) {
			answer[i] = Integer.parseInt(entry.getKey());
			i++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
	}

}
