package OurAlgorism_October;
/*
 * 프로그래머스 깊이/넓이 우선탐색 1번 문제 타겟넘버(파이썬 풀이도 있음)
 */
public class Programmers_BFS_DFS_1 {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        return fun(numbers,target,0);
    }
     public int fun(int[] numbers, int target, int i) {
        if(i==numbers.length){
            if(target==0)
                return 1;
            else
                return 0;
        }
        return fun(numbers,target-numbers[i],i+1)+fun(numbers,target+numbers[i],i+1);
    }

}
