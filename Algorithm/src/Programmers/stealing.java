/**
 * 
 */
package Programmers;

import java.util.Arrays;

import SamsungExpertAcademy.view;

/**
  * @FileName : stealing.java
  * @Project : Algorithm
  * @Date : 2019. 9. 21.
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 동적계획법 도둑질 문제
 */
public class stealing {
	
	
	
	int [] money;
	int max = -1;
	
	public static void main(String[] args) {
		
		
	}
	
	public int solution(int[] money) {
        int answer = 0;
        
        this.money=money;
        
        return answer;
    }
	
	public void DP(int now, int sum, boolean[] visited) {
		
		if(max<sum) {
			max=sum;
			
			return;
		}
		boolean[] newVisited = Arrays.copyOf(visited, visited.length);
		newVisited[now] = true;
		sum += money[now];
		
		
		
	}

}
