package Programmers;
/**
 * 
  * @FileName : Carpet.java
  * @Project : Algorithm
  * @Date : 2020. 1. 8. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 완전탐색 카펫 문제 풀이 완료.
 */
public class Carpet {
	
	public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int totalLength = brown/2 + 2; // width + height
        int width, height;
        
        width = height = totalLength/2;
        
        if(totalLength%2 == 1)
        	width++;
        
        while(true) {
        	if((width-2)*(height-2)==red)
        		break;
        	
        	width++;
        	height--;
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
	
	public static void main(String[] args) {

	}

}
