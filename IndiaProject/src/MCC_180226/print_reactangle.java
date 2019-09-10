package MCC_180226;

import java.util.Scanner;
/**
 *홀수개의 문자를 입력하면 안에 다이아몬드 만들기
 * 
 * @Package : MCC_180226
 * @FileName : print_reactangle.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class print_reactangle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String st=sc.next();
		StringBuffer sb=new StringBuffer(st);
		String blank=" ";
		String[] arr=new String[100];
		int cen=st.length()/2;
		arr[0]=sb.toString();//st:입력글자 저장,sb=replace를 쓰기 위한 StringBuffer,blank는 대체시키기 위한 공간,arr은 문자 하나씩 저장하는 배열
		System.out.println(sb);
		for(int i=0;i<cen;i++) {
			sb.replace(cen-i, cen+1+i, blank);
			blank+="  ";
			arr[i+1]=sb.toString();
			System.out.println(sb);
		}//위의 다이아 몬드 출력
		for(int i=cen-1;i>=0;i--) {
			System.out.println(arr[i]);//밑의 다이아몬드 출력
		}
	}
}
