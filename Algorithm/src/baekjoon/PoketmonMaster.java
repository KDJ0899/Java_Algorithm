package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 
  * @FileName : PoketmonMaster.java
  * @Project : Algorithm
  * @Date : 2020. 4. 3. 
  * @Author : Kim DongJin
  * @Comment :백준 1620 나는야 포켓몬 마스터 이다솜 문제 풀이 완료.
 */
public class PoketmonMaster {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		String name, index;
		Map<String, String> book = new HashMap<String, String>();
		
		for(int i=1; i<=N; i++) {
			name = sc.next();
			index = String.valueOf(i);
			book.put(name, index);
			book.put(index, name);
		}
		for(int i=0; i<M; i++) {
			name = sc.next();
			System.out.println(book.get(name));
		}
	}

}
