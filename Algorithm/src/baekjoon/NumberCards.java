package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
  * @FileName : NumberCards.java
  * @Project : Algorithm
  * @Date : 2020. 9. 26. 
  * @Author : Kim DongJin
  * @Comment : 백준 10816 숫자카드 2문제 풀이
 */
public class NumberCards {
	
    static final int UPPER_MAX = 10000000;
    static final int MAX_ARRAY = (UPPER_MAX*2) +1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine()),answer,M;
		
		int[] cards = new int[MAX_ARRAY];
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			cards[Integer.valueOf(st.nextToken()) +UPPER_MAX]++;
		}
		
		M = Integer.valueOf(br.readLine());
        st  = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sb.append(cards[Integer.valueOf(st.nextToken())+UPPER_MAX] + " ");
		}
		System.out.println(sb.toString());
	}
}
