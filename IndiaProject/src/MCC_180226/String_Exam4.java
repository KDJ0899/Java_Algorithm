package MCC_180226;

import java.util.StringTokenizer;
/**
 * 자바 String 함수 예제
 * 
 * @Package : MCC_180226
 * @FileName : String_Exam4.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class String_Exam4 {

	public static void main(String[] args) {
		StringTokenizer st=new StringTokenizer("My name is khan"," ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		st=new StringTokenizer("My,name,is,khan");
		while(st.hasMoreTokens()) {
			System.out.println("Next token is:"+st.nextToken(","));
		}

	}

}
