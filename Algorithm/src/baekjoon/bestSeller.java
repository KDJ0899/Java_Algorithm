package baekjoon;

import java.util.HashMap;
import java.util.Scanner;
/**
 * 
  * @FileName : bestSeller.java
  * @Project : Algorithm
  * @Date : 2019. 4. 30. 
  * @Author : Kim DongJin
  * @Comment :백준 1302 베스트셀러 문제 (해결)
 */
public class bestSeller {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String word;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int[] books= new int[1000];
		String[] bookName=new String[1000];
		int booksNum=0;
		int max=0;
		String answer="";
		for(int i=0; i<n; i++) {
			word=sc.next();
			
			if(map.containsKey(word)) {
				books[map.get(word)]++;
			}
			else {
				map.put(word, booksNum);
				books[booksNum]++;
				bookName[booksNum]=word;
				booksNum++;
			}
		}
		
		for(int i=0; i<booksNum;i++) {
			if(max<books[i]) {
				max=books[i];
				answer=bookName[i];
			}
			else if(max==books[i]) {
				if(bookName[i].compareTo(answer)<0) {
					answer=bookName[i];
				}
			}
		}
		
		System.out.println(answer);
		sc.close();

	}

}
