package kakao_internship_2020;

import java.util.*;

/**
 * 
  * @FileName : Programming5.java
  * @Project : Algorithm
  * @Date : 2020. 5. 23. 
  * @Author : Kim DongJin
  * @Comment : 동굴을 모두 탐사하는데, 선행으로 탐사해야 하는 구간이 있음.
 */

public class Programming5 {
	
	public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = false;
        
        Map<Integer, List<Integer>> relations = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> rule = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> essentialRooms = new HashSet<Integer>();
        int ruleNum;
        
        int x,y,nowRoom = 0;
        
        for(int i=0; i<path.length; i++) {
        	x = path[i][0];
        	y = path[i][1];
        	
        	if(!relations.containsKey(x))
        		relations.put(x, new ArrayList<Integer>());
        	if(!relations.containsKey(y))
        		relations.put(y, new ArrayList<Integer>());
        	
        	relations.get(x).add(y);
        	relations.get(y).add(x);
        		
        }
        
        for(int i=0; i<order.length; i++) {
        	x = order[i][0];
        	y = order[i][1];
        	
        	rule.put(y, x);
        	essentialRooms.add(x);
        }
        
       do {
    	   visited = new HashSet<Integer>();
    	   ruleNum = essentialRooms.size();
    	   
    	   visit(nowRoom, relations, rule, visited,essentialRooms);
    	   System.out.println(ruleNum+"  "+essentialRooms.size());
    	   
       }while(essentialRooms.size()!=0 && ruleNum != essentialRooms.size());
       
        if(essentialRooms.size()==0)
        	answer = true;
        
        return answer;
    }
	
	
	public static void visit (int nowRoom, Map<Integer, List<Integer>> relations, Map<Integer, Integer> rule, Set<Integer> visited,Set<Integer> essentialRooms) {
		if(visited.contains(nowRoom))
			return;
		
		if(essentialRooms.contains(nowRoom))
			essentialRooms.remove(nowRoom);
		
		if(rule.containsKey(nowRoom)) {
			if(essentialRooms.contains(rule.get(nowRoom)))
				return;
			
			rule.remove(nowRoom);
		}
		
		List<Integer> rooms = new ArrayList<Integer>();
		visited.add(nowRoom);
		System.out.println(nowRoom);
		
		if(relations.containsKey(nowRoom)) {
			rooms = relations.get(nowRoom);
			for(int room : rooms) {
				visit(room, relations, rule, visited, essentialRooms);
			}
		}
	}
	
	public static void main(String[] args) {
		
		
//		System.out.println(solution(9, new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][] {{8,5},{6,7},{4,1}}));
		
		System.out.println(solution(9, new int[][] {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}}, new int[][] {{4,1},{5,2}}));
	}
	

}
