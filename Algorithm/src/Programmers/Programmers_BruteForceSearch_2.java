package Programmers;
/*
 * 프로그래머스 완전탐색 2번 소수찾기
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_BruteForceSearch_2 {
	 static ArrayList<Integer> answers=new ArrayList<>();
	 static char[] words;
	
	 public static int solution(String numbers) {
	        int answer = 0;
	        words=numbers.toCharArray();
	        boolean[] used;
	        
	        for(int i=0;i<words.length;i++) {
	        	used = new boolean[words.length];
	        	used[i]=true;
	        	recursion(Integer.parseInt(words[i]+""),used);
	        }
	        return answers.size();
	    }
	 public static void recursion(int number,boolean[] used) {
		 System.out.println(number+" "+Arrays.toString(used));
		 boolean prime=true;
		 boolean dupl=false;
		 int count=0;
		 boolean[] newUsed;
		 for(int i=2;i<number;i++) {
			 if(number%i==0) {
				 prime=false;
				 break;
			 }
		 }
		 if(prime&&number>1) {
			 for(int i=0;i<answers.size();i++) {
				 if(answers.get(i)==number) {
					 dupl=true;
					 break;
				 }
			 }
			 if(!dupl)
				 answers.add(number);
		 }
		 for(int i=0;i<used.length;i++) {
			 if(used[i])
				 count++;
		 }
		 if(count==words.length)
			 return;
		 else {
			 for(int i=0;i<words.length;i++) {
				 newUsed = used.clone();
				 if(!used[i]) {
					newUsed[i]=true;
		        	recursion(Integer.parseInt(number+""+words[i]),newUsed);
				 }
		      }
		 }
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(solution("1234"));
		 System.out.println(answers.toString());
	 }
}
