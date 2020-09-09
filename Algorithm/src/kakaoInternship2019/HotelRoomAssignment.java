package kakaoInternship2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @FileName : HotelRoomAssignment.java
 * @Project : Algorithm
 * @Date : 2020. 9. 9.
 * @Author : Kim DongJin
 * @Comment : 카카오 2019 겨울 인턴쉽 호텔 방 배정 문제 풀이 완료.
 */
public class HotelRoomAssignment {

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		Map<Long, Long> room = new HashMap<Long, Long>();
		
		for(int i=0; i<room_number.length; i++) {
			long num = room_number[i];
			
			answer[i] = searchRoom(num, room)-1;
		}
		
		return answer;
	}
	
	public static long searchRoom(long roomNum, Map<Long, Long> room) {
		if(room.containsKey(roomNum)) {
			room.put(roomNum, searchRoom(room.get(roomNum), room));
		}else {
			room.put(roomNum, roomNum+1);
		}
		
		return room.get(roomNum);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, new long[] {1,3,4,1,3,1})));
	}

}
