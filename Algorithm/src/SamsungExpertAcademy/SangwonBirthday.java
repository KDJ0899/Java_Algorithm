package SamsungExpertAcademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * 
  * @FileName : SangwonBirthday.java
  * @Project : Algorithm
  * @Date : 2020. 4. 10. 
  * @Author : Kim DongJin
  * @Comment : SW Expert Academy 5521. D5 상원이의 생일파티 문제 풀이 완료.
 */
public class SangwonBirthday {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), N, M, x, y;
		Set<Integer> invitation;
		Map<Integer, List<Integer>> relation;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			relation = new HashMap<Integer, List<Integer>>();
			invitation = new HashSet<Integer>();
			
			for(int i=0; i<M; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				
				if(!relation.containsKey(x))
					relation.put(x, new ArrayList<Integer>());
				relation.get(x).add(y);
				
				if(!relation.containsKey(y))
					relation.put(y, new ArrayList<Integer>());
				relation.get(y).add(x);
			}
			
			if(relation.containsKey(1)) {
				for(int friend : relation.get(1)) {
					if(relation.containsKey(friend)) {
						for(int otherFriend : relation.get(friend))
							invitation.add(otherFriend);
					}
					
					invitation.add(friend);
				}
				
				if(invitation.contains(1))
					invitation.remove(1);
			}
			
			System.out.println("#"+test_case+" "+invitation.size());
			
			
		}
	}

}
