package Programmers;

import java.util.HashMap;

/**
 * 
  * @FileName : WordPuzzle.java
  * @Project : Algorithm
  * @Date : 2020. 2. 26. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 단어 퍼즐 문제 풀이.
 */

class WordTree {
	public HashMap<Character, WordTree> next;
	
	public WordTree() {
		next = new HashMap<Character, WordTree>();
	}
}

public class WordPuzzle {
	
	public static int solution(String[] strs, String t) {
        int answer = 0;
        WordTree root = new WordTree();
        WordTree tmp;
        char[] word;
        char letter;
        HashMap<Character, WordTree> tmpMap;
        
        for(int i=0; i<strs.length; i++) {
        	word = strs[i].toCharArray();
        	tmp = root;
        	for(int j=0; j<word.length; j++) {
        		letter = word[j];
        		tmpMap = tmp.next;
        		if(!tmpMap.containsKey(letter))
        			tmpMap.put(letter, new WordTree());
        		
        		tmp = tmpMap.get(letter);
        	}
        }
        
        word = t.toCharArray();
        tmp =root;
        
        for(int i=0; i<word.length; i++) {
        	letter = word[i];
        	tmpMap = tmp.next;
        	
        	if(tmpMap.containsKey(letter)) {
        		tmp = tmpMap.get(letter);
        	}
        	else {
        		if(tmp.equals(root)) {
        			answer = -1;
        			break;
        		}
        		
        		tmp = root;
        		answer++;
        		i--;
        	}
        }
        
        if(answer!=-1)
        	answer++;
        	
        return answer;
    }

	public static void main(String[] args) {
		
		System.out.println(solution(new String[] {"ba","na","n","a"}, "banana"));

	}

}



