package SamsungExpertAcademy;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
  * @FileName : CommonAncestors.java
  * @Project : Algorithm
  * @Date : 2019. 12. 17. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy  D5 공통조상 문제 풀이 
 */
public class CommonAncestors {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, int[]> tree = new HashMap<Integer, int[]>();
		
		int n = sc.nextInt();
		int v,e,x,y,parent,child;
		int[] arr;
		for(int i=0; i<n; i++) {
			v = sc.nextInt();
			e = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int j=0; j<e; j++) {
				parent = sc.nextInt();
				child = sc.nextInt();
				
				if(!tree.containsKey(parent))
					tree.put(parent, new int[] {child,0});
				else {
					arr = tree.get(parent);
					arr[1]= child;
					tree.put(parent,arr);
				}
			}
			
		}
	}
//	
//	public List<Integer> search(){
//		
//		
//	}

}
