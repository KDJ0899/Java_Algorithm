package SamsungExpertAcademy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
  * @FileName : lineUp.java
  * @Project : Algorithm
  * @Date : 2019. 8. 2. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 7991. D5 줄 세우기 문제 풀이 (런타임 에러)
 */
public class lineUp {
	
	static ArrayList<Integer> answerList;
	static boolean finish=false;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int T,n;
		ArrayList<Integer> list;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			
			finish=false;
			answerList = new ArrayList<Integer>();
			list = new ArrayList<Integer>();
			
			for(int i=0; i<n; i++) {
				list.add(sc.nextInt());
			}
			
			list.sort(null);
			
			solution(list, new ArrayList<Integer>());
			
			System.out.print("#"+test_case);
			for(int i=0; i<answerList.size(); i++) {
				System.out.print(" "+answerList.get(i));
			}
			System.out.println();
			
			
		}

	}
	
	public static void solution (ArrayList<Integer> list, ArrayList<Integer> answer) {
		
		if(list.size()==0) {
			answerList = answer;
			finish = true;
			return;
		}
		
		int num=0;
		
		for(int i=0; i<list.size(); i++) {
			
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			
			ArrayList<Integer> newAnswer = new ArrayList<Integer>();
			newAnswer.addAll(answer);
			
			if(finish)
				return;
			
			if(num!=list.get(i)) {
				num=list.get(i);
				
				if(answer.size()==0) {
					newAnswer.add(num);
					
					newList.remove(i);
					solution(newList, newAnswer);
				}
				else if(num!=answer.get(answer.size()-1)+1) {
					newAnswer.add(num);
					
					newList.remove(i);
					solution(newList, newAnswer);
				}
			}
		}
		
	}

}
