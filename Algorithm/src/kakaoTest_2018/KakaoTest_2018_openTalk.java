package kakaoTest_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * 2018 카카오 블라인드테스트 오픈카톡 문제 (완료)
 * 
 * @Package : OurAlgorism_October
 * @FileName : KakaoTest_2018_openTalk.java
 * @Author : KIM DONGJIN
 * @date : 2018. 11. 7. 
 *
 */
public class KakaoTest_2018_openTalk {
	 public static String[] solution(String[] record) {
	        String[] answer;
	        String[] commands;
	        
	        ArrayList<String[]> list=new ArrayList<>();
			HashMap map=new HashMap<>();
			
	        for(int i=0;i<record.length;i++) {
	        	commands=record[i].split(" ");
	        	if(!commands[0].equals("Change"))
	        		list.add(commands);
	        	if(!commands[0].equals("Leave"))
	        		map.put(commands[1], commands[2]);
	        }
	        
	        answer=new String[list.size()];
	        
	        for(int i=0;i<list.size();i++) {
	        	answer[i]=(String) map.get(list.get(i)[1]);
	        	if(list.get(i)[0].equals("Enter")) {
	        		answer[i]+="님이 들어왔습니다.";
	        	}
	        	else
	        		answer[i]+="님이 나갔습니다.";
	        }

	        return answer;
	    }

	public static void main(String[] args) {
		String[] arr= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(arr)));

		

	}

}
