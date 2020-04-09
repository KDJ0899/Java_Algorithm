package SamsungExpertAcademy;

import java.util.Scanner;
/**
 * 
  * @FileName : SortingComicBook.java
  * @Project : Algorithm
  * @Date : 2020. 4. 9. 
  * @Author : Kim DongJin
  * @Comment :SW Expert Academy 8191. D5 만화책 정렬하기 문제 풀이 완료.
 */
public class SortingComicBook {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), N, book, answer, index;
		int[] books;
		
		for(int test_case = 1; test_case<=T; test_case++) {
			N = sc.nextInt();
			books = new int[N+1];
			answer = 1;
			for(int i=1; i<=N; i++) {
				book = sc.nextInt();
				books[book] = i; 
			}
			book = 1;
			index = 0;
			for(int i=1; i<=N; i++) {
				if(books[i]<index) 
					answer++;
				index = books[i];
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}

	}

}
