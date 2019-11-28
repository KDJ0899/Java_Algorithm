
package KaKaoTest_2020;

/**
  * @FileName : compressString.java
  * @Project : Algorithm
  * @Date : 2019. 11. 18.
  * @Author : Kim DongJin
  * @Comment : 2020카카오 문자열 압축 문제 풀이 (완료)
 */
public class CompressString {

	/**
	 * @param args
	 */
	
	  public static int solution(String s) {
	        int count;
	        double length = s.length();
	        int min = (int)length;
	        String target,sub,newWord;
	        
	        for(int i=1; i<=length/2; i++) {
        		count=1;
        		target="";
        		newWord="";
        		
        		for(int j=0;j<Math.ceil(length/i); j++) {
        			
        			if((j+1)*i>=length)
        				sub = s.substring(j*i);
        			else
        				sub = s.substring(j*i,(j+1)*i);
        			
        			if(target.equals(sub)) {
        				count++;
        			}
        			else {
        				if(count==1) {
        					newWord+=target;
        				}
        				else {
        					newWord+=count+target;
        				}
        				
        				target=sub;
        				count=1;
        			}
        		
        		}
        		if(count==1) {
					newWord+=target;
				}
				else {
					newWord+=count+target;
				}
        		min = Math.min(min, newWord.length());
        
	        }
	        
	        return min;
	    }
	  
	public static void main(String[] args) {
		System.out.println("Answer: "+solution("aabbaccc"));
		System.out.println("Answer: "+solution("ababcdcdababcdcd"));
		System.out.println("Answer: "+solution("abcabcdede"));
		System.out.println("Answer: "+solution("abcabcabcabcdededededede"));
		System.out.println("Answer: "+solution("xababcdcdababcdcd"));
	}

}
