/**
 *
 */
package SamsungExpertAcademy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
  * @FileName : nameSorting.java
  * @Project : Algorithm
  * @Date : 2019. 7. 9. 
  * @Author : Kim DongJin
  * @Comment : Samsung Expert Academy 7701. D4 염라대왕의 이름 정렬 문제 풀이 
 */
public class nameSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		HashSet<String> set = null;
		Set<Integer> keySet;
		HashMap<Integer,HashSet<String>> map = new HashMap<Integer,HashSet<String>>();
		
		Object[] arr = null;
		int testcase,n,a,num;
		String word;
		
		Iterator<Integer> it;
		
		testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			n = sc.nextInt();
			set = new HashSet<String>();
			
			for(int j=0; j<n; j++) {
				word=sc.next();
				if(map.containsKey(word.length()))
					map.get(word.length()).add(word);
				else {
					set = new HashSet<String>();
					set.add(word);
					map.put(word.length(), set);
				}
			}
			
			keySet = map.keySet();
			it = keySet.iterator();
			a=0;
			System.out.println("#"+(i+1)); 
			
			while(it.hasNext()) {
				num=it.next();
				set=map.get(num);
				
				arr=set.toArray();
				Arrays.sort(arr);
				for(int j=0; j<arr.length; j++) {
					System.out.println(arr[j]);
				}
				a++;
			}
			
		}
		
		sc.close();

	}

}
