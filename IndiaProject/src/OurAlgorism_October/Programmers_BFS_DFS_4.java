package OurAlgorism_October;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * 프로그래머스 깊이/넓이 우선탐색 4번 문제 여행경로
 */
public class Programmers_BFS_DFS_4 {
	 public static String[] solution(String[][] tickets) {
	 	String[] answer = new String[tickets.length+1];
	 	boolean[] used=new boolean[tickets.length+1];
	 	
		answer[0]="ICN";
		
		plane(tickets,used,answer,0);
		
        return answer;
    }
	 public static boolean plane(String[][] tickets,boolean[] used,String[] answer,int j) {
		 ArrayList<String> go=new ArrayList<>();
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
		 boolean[] newUsed=new boolean[used.length];
		 
		 for(int i=0; i<used.length;i++) {
			 newUsed[i]=used[i];
		 }
		
		 for(int i=0;i<tickets.length;i++) {
			 if(used[i])
				 continue;
			 
	 		if(tickets[i][0].equals(answer[j])) {
	 			go.add(tickets[i][1]);
	 			map.put(tickets[i][1], i);
	 		}
		 }
		 go.sort(null);

	 	 for(int i=0;i<go.size();i++) {
	 		answer[j+1]=go.get(i);
	 		newUsed[map.get(go.get(i))]=true;
	 		
	 		if(plane(tickets,newUsed,answer,j+1)) {
	 			return true;
	 		}

	 		newUsed[map.get(go.get(i))]=false;
	 	 }
	 	 
	 	 if(j==tickets.length)
	 		 return true;
	 	 
	 	 return false; 
	 }

    public static void main(String[] a) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(1, 2);
    	map.put(1, 3);
        System.out.println(map.get(1));
    }
}