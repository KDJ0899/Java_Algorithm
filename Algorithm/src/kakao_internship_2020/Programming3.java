package kakao_internship_2020;

import java.util.*;
/**
 * 
  * @FileName : Programming3.java
  * @Project : Algorithm
  * @Date : 2020. 10. 07
  * @Author : Kim DongJin
  * @Comment : 카카오 인턴십 2020 보석쇼핑 문제, 모든 보석을 사는 조건에서 최소 갯수 구하기. 투포인터
 */
public class Programming3 {
	
	public static int[] solution(String[] gems) {
		int[] answer = {1, gems.length};
		int start=0, num;
		String gem;
		Set<String> types = new HashSet<String>();
		Map<String, Integer> gemNum = new HashMap<String, Integer>();
		Queue<String> que = new LinkedList<String>();
		
		for(int i=0; i<gems.length; i++) {
			types.add(gems[i]);
		}
		
		for(int i=0; i<gems.length; i++) {
			gem = gems[i];
			if(!gemNum.containsKey(gem))
				gemNum.put(gem,0);
			gemNum.put(gem, gemNum.get(gem)+1);
			
			que.add(gem);
			
			while(true) {
				gem = que.peek();
				num = gemNum.get(gem);
				if(num>1) {
					gemNum.put(gem, num-1);
					start++;
					que.poll();
				}else {
					break;
				}
			}
			
			if(gemNum.size() == types.size() && answer[1] - answer[0] > i - start) {
				answer[0] = start+1;
				answer[1] = i+1;
			}
			
		}

        return answer;
	}

	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
		System.out.println(Arrays.toString(solution(new String[] {"AA", "AB", "AC", "AA", "AC"})));
		System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XYZ", "XYZ"})));
		System.out.println(Arrays.toString(solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
	}

}
