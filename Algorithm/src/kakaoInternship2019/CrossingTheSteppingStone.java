package kakaoInternship2019;

import java.util.*;
/**
 * 
  * @FileName : CrossingTheSteppingStone.java
  * @Project : Algorithm
  * @Date : 2020. 9. 11. 
  * @Author : Kim DongJin
  * @Comment : 카카오 2019 겨울 인턴쉽 징검다리 건너기 문제 풀이 완료
 */
public class CrossingTheSteppingStone {
	public static int solution(int[] stones, int k) {
		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int stone : stones) {
			max = Math.max(max, stone);
			min = Math.min(min, stone);
		}
		
		return binarySearch(stones, max, min, k);
	}

	public static int binarySearch(int[] stones, int hi, int lo, int k) {
		 if (hi == lo) return lo;
		 
		while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (canCross(stones, mid, k)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo - 1;
	}

	public static boolean canCross(int[] stones, int people, int k) {
		int count = 0;
		for (int stone : stones) {
			if (stone - people <= 0) {
				count++;
			} else {
				count = 0;
			}
			
			if (count == k) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3));
	}

}
