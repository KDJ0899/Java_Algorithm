package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
  * @FileName : WordPuzzle.java
  * @Project : Algorithm
  * @Date : 2020. 2. 26. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 단어 퍼즐 문제 풀이.
 */

public class WordPuzzle {
	static int result;
	
	public static int solution(String[] strs, String t) {
        result = -1;
        
        HashMap<Character, List<String>> wordBox = new HashMap<Character, List<String>>();
        HashSet<String> words = new HashSet<String>();
        char fisrtLetter;
        List<String> list;
        for(int i=0; i<strs.length; i++) {
        	if(t.contains(strs[i])) {
	        	words.add(strs[i]);
	        	fisrtLetter = strs[i].charAt(0);
	        	
	        	if(wordBox.containsKey(fisrtLetter)) 
	        		wordBox.get(fisrtLetter).add(strs[i]);
	        	else {
	        		list = new ArrayList<String>();
	        		list.add(strs[i]);
	        		wordBox.put(fisrtLetter,list);
	        	}
        	}
        	
        }
        serachBestAnswer(t, 0, wordBox,words);
        return result;
    }
	
	public static void serachBestAnswer(String remainWord,int answer,HashMap<Character, List<String>> wordBox,HashSet<String> words) {
		if(words.contains(remainWord)) {
			answer++;
			if(result==-1||result>answer)
				result = answer;
			return;
		}
		char firstLetter = remainWord.charAt(0);
		String word;
		List<String> list;
		
		if(wordBox.containsKey(firstLetter)) {
			list = wordBox.get(firstLetter);
			
			for(int i=0; i<list.size(); i++) {
				word = list.get(i);
				if(remainWord.startsWith(word)) {
					serachBestAnswer(remainWord.substring(word.length()), answer+1, wordBox, words);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("baba".contains("aba"));
		System.out.println(solution(new String[] {"ba","na","n","a"}, "banana"));
		System.out.println(solution(new String[] {"app","ap","p","l","e","ple","pp"}, "apple"));
		System.out.println(solution(new String[] {"ba","an","nan","ban","n"}, "banana"));
	}

}



