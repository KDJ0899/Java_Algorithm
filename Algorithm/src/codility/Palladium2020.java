package codility;

import java.util.Arrays;
/**
 * 
  * @FileName : Palladium2020.java
  * @Project : Algorithm
  * @Date : 2020. 3. 24. 
  * @Author : Kim DongJin
  * @Comment : codility Palladium 2020 문제 풀이 완료.
 */
public class Palladium2020 {
	public static int solution(int[] H) {
		int min,length = H.length, sum;
        
        int[] front,back;
        
        front = H.clone();
        
        Arrays.sort(front);
        min = front[length-1]*length;
        
        for(int i=1; i<length; i++){
        	System.out.println(min);
            front = Arrays.copyOfRange(H, 0, i);
            back = Arrays.copyOfRange(H, i, length);
            Arrays.sort(front);
            Arrays.sort(back);
            sum = front[i-1]*i+back[length-(i+1)]*(length-i);
            min = Math.min(min, sum);
        }
		
		return min;
	}
	
	public static void main(String[] args) {
//		System.out.println(solution(new int[] {1,1,7,6,6,6}));
		System.out.println(solution(new int[] {3,1,4}));
	}
}
