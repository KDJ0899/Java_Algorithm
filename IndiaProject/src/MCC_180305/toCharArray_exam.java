package MCC_180305;
/**
 * toCharArray는 String문장을 Char형 배열로 바꾸어주는 함수
 * 
 * @Package : MCC_180305
 * @FileName : toCharArray_exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class toCharArray_exam {

	public static void main(String[] args) {
		String s1="hello";
		char[] ch=s1.toCharArray();
		for(int i=0;i<ch.length;i++)
			System.out.println(ch[i]);

	}

}
