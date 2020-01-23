/**
 * 
 */
package kaKaoTest_2020;

/**
  * @FileName : Wallinspection.java
  * @Project : Algorithm
  * @Date : 2019. 11. 30.
  * @Author : Kim DongJin
  * @Comment :2020카카오 외벽전검 문제. (진행중)
 */
public class Wallinspection {
	
	int bestAnswer=9;

	public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int longestLength=0,x,y,target;
        int post = weak[0];
        
        for(int i=1; i<weak.length; i++) {
        	if(post<n/2)
        		target = Math.min(post-weak[i], post+n-weak[i]);
        	else
        		target = post - weak[i];
        	
        	if(longestLength<target) {
        		longestLength = target;
        		x=i-1;
        		y=i;
        	}
        	post = weak[i];
        }
        
        target = weak[0]+n-post;
        if(longestLength<target) {
    		longestLength = target;
    		x=0;
    		y=weak.length-1;
    	}
        
        
        
        return answer;
    }
	
	public void recursion(int start, int end, int cnt, int[] weak, boolean up) {
		
		if(cnt>=bestAnswer) {
			return;
		}
		
		if(up) {
			
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
