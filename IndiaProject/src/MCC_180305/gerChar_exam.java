package MCC_180305;
/**
 * getChars(int BeginIndex, int EndIndex, char[] Destination,int dstBeginIndex)
 * String의 시작지점과 끝지점을 입력해 원하는 char배열에 넣기.
 * 
 * @Package : MCC_180305
 * @FileName : gerChar_exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class gerChar_exam {

	public static void main(String[] args) {
		String Str=new String("Hello students how r u");
		char[]ch=new char[10];
		try {
			Str.getChars(6,16,ch,0);
			System.out.println(ch);
		}catch(Exception e) {System.out.println(e);}

	}

}
