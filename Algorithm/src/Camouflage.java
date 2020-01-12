import java.util.HashMap;
import java.util.List;

/**
 * 
  * @FileName : Camouflage.java
  * @Project : Algorithm
  * @Date : 2020. 1. 12. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 해시 위장 문제 풀이
 */
public class Camouflage {
	
	public int solution(String[][] clothes) {
        int answer = 0;
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
        
        for(String tmp : typeOfClothes.keySet()) {
        	
        	answer+=typeOfClothes.get(tmp);
        	
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
