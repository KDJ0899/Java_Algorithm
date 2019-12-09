package Programmers;

/**
 * 
  * @FileName : truckPassingBridge.java
  * @Project : Algorithm
  * @Date : 2019. 3. 12. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 다리를 지나는 트럭 문제
 */

public class truckPassingBridge {

	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowWeight=0;
        int front=0, nowNum=0;
        int[] nowTruckLocate=new int[truck_weights.length];
        
        for(int i=0; i<truck_weights.length; i++) {
        	nowWeight+=truck_weights[i];
        		
        	if(nowWeight>weight) {
        		for(int j=front+1;j<front+nowNum; j++) {
        			nowTruckLocate[j]+=bridge_length-nowTruckLocate[front];
        		}
        		answer+=bridge_length-nowTruckLocate[front];
        		nowWeight-=truck_weights[front];
        		front++;
        		nowNum--;
        		
        		if(nowWeight>weight) {
        			nowWeight-=truck_weights[i];
        			i--;
        			continue;
        		}
        	}
        	
        	else {
        		for(int j=front; j<front+nowNum; j++) {
        			if(++nowTruckLocate[j]>=bridge_length) {
        				nowWeight-=truck_weights[front];
        				front++;
        				nowNum--;
        			}
        		}
        		answer++;
        	}
        	
        	nowNum++;
        	
        }
        answer+=bridge_length-nowTruckLocate[truck_weights.length-1];
           
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[]{7,4,5,6}));
		System.out.println(solution(100, 100, new int[]{10}));
		System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
			
	}

}
