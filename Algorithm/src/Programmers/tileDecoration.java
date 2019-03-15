/**
 *
 */
package Programmers;

import java.util.ArrayList;
import java.util.List;

/**
  * @FileName : tileDecoration.java
  * @Project : Algorithm
  * @Date : 2019. 3. 15. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적 계획법 - 타원 장식물 (완료)
 */
public class tileDecoration {
	
	public static long solution(int N) {
        long answer = 0;
        List<Long> list=new ArrayList<Long>();
        
        if(N==1)
        	return 2;
        
        list.add(1L);
        list.add(1L);
        
        for(int i=2;i<N; i++){
        	
            list.add(Long.sum(list.get(0), list.get(1)));
            list.remove(0);
        }
        
        answer=(list.get(0)+list.get(1))*2+list.get(1)*2;
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(2));

	}

}
