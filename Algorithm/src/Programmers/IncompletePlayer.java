package Programmers;

import java.util.HashMap;

/**
 * 
  * @FileName : IncompletePlayer.java
  * @Project : Algorithm
  * @Date : 2019. 12. 17. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 완주하지 못한 선수 문제 (완료)
 */
public class IncompletePlayer {
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> completions = new HashMap<>();
        String player;
        
        for(int i=0; i<completion.length; i++) {
        	player = completion[i];
        	if(completions.containsKey(player)) 
        		completions.put(player, completions.get(player)+1);
        	else
        		completions.put(completion[i], 1);
        }
        
        for(int i=0; i<participant.length; i++) {
        	player = participant[i];
        	if(!completions.containsKey(player)) {
        		answer = player;
        		break;
        	}
        	else {
        		if(completions.get(player)==0) {
        			answer = player;
            		break;
        		}
        		else {
        			completions.put(player, completions.get(player)-1);
        		}
        			
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
