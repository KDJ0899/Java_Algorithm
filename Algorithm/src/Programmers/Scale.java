package Programmers;

import java.util.Arrays;

/**
 * 
  * @FileName : Scale.java
  * @Project : Algorithm
  * @Date : 2020. 1. 9. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 탐욕법 저울 문제 풀이 (완료)
 */
public class Scale {
	
	public int solution(int[] weight) {
        int answer = 0;
        int nowSum = 0;
        boolean end =false;
        
        Arrays.sort(weight);
        
        for(int i=0; i<weight.length; i++) {
            System.out.println(nowSum);
        	if(nowSum+1 < weight[i]) {
        		answer = nowSum +1;
        		end = true;
        		break;
        	}
            
            nowSum +=weight[i];
            
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
