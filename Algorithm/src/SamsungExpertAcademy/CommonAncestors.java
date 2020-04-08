package SamsungExpertAcademy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
  * @FileName : CommonAncestors.java
  * @Project : Algorithm
  * @Date : 2020. 4. 8. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy  D5 공통조상 문제 풀이 완료
 */
public class CommonAncestors {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(), V, E, x, y, p, c;
		int[] parents, subNodeNum;
		Set<Integer> ancestors;
		
		for(int test_case = 1; test_case<=T; test_case++) {
			V = sc.nextInt();
			E = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			parents = new int[V+1];
			subNodeNum = new int[V+1];
			subNodeNum[1] = 1;
			parents[1] = 0;
			ancestors = new HashSet<Integer>();
			
			for(int i=0; i<E; i++) {
				p = sc.nextInt();
				c = sc.nextInt();
				
				parents[c] = p;
				subNodeNum[c]++;
				arrange(parents, subNodeNum, c, subNodeNum[c]);
			}
			while(x!=1) {
				x = parents[x];
				ancestors.add(x);
			}
			while(y!=1) {
				y = parents[y];
				if(ancestors.contains(y))
					break;
				ancestors.add(y);
			}
			
			System.out.println("#"+test_case+" "+y+" "+subNodeNum[y]);
		}
	}
	
	public static void arrange(int[] parents, int[] subNodeNum, int index, int value) {
		while(index>1) {
			index = parents[index];
			subNodeNum[index]+= value;
		}
	}

}
