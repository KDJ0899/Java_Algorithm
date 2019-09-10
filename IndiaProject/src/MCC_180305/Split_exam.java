package MCC_180305;
/**
 * Split() 함수는 괄호안에 넣은 값을 기준으로 끊어냄.
 * 
 * @Package : MCC_180305
 * @FileName : Split_exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class Split_exam {
	public static void main(String[] args) {
		String s1="java string split method by javatpoint";
		String[] words=s1.split("\\s");
		for(String w:words){
			System.out.println(w);
		}
		System.out.println();
		String str="How to split stilngs in java";
		String s2=" ";
		words=str.split(s2,4);
		for(int i=0;i<words.length;i++)
			System.out.println(words[i]);
	}

}
