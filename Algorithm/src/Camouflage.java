import java.util.HashMap;

/**
 * 
  * @FileName : Camouflage.java
  * @Project : Algorithm
  * @Date : 2020. 1. 12. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 해시 위장 문제 풀이 완료
 */
public class Camouflage {
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        String type;
        
        HashMap<String, Integer> typeOfClothes = new HashMap<String, Integer>();
        
        for(int i=0; i<clothes.length; i++) {
        	
        	type = clothes[i][1];
        	
        	if(typeOfClothes.containsKey(type))
        		typeOfClothes.put(type, typeOfClothes.get(type)+1);
        	else {
        		typeOfClothes.put(type, 1);
        	}
        	
        }
        
       for(String key :typeOfClothes.keySet()) {
    	   
    	   answer *= (typeOfClothes.get(key)+1);
       }
        
        return answer-1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"y","h"},{"b","e"},{"g","h"}}));
		System.out.println(solution(new String[][] {{"y","h"},{"b","h"},{"g","h"}}));

	}

}
