package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
  * @FileName : Zirconium2019.java
  * @Project : Algorithm
  * @Date : 2020. 3. 27. 
  * @Author : Kim DongJin
  * @Comment : 코딜리티 Zirconium2019 문제 풀이 완료
 */
public class Zirconium2019 {
	class Developer{
		int index;
		int value;
		
		public Developer(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	public int solution(int[] A, int[] B, int F) {
		int answer =0 ;
		List<Developer> gaps = new ArrayList<Developer>();
		
		for(int i=0; i<A.length; i++) {
			gaps.add(new Developer(i, A[i]-B[i]));
		}
		
		Collections.sort(gaps, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o2.value - o1.value;
			}
		});
		
		for(int i=0; i<A.length; i++) {
			if(i<F)
				answer+=A[gaps.get(i).index];
			else
				answer+=B[gaps.get(i).index];
		}
		
		return answer;
	}
}
