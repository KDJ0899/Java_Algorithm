package MCC_180305;
/**
 * format 함수 사용.
 * 
 * @Package : MCC_180305
 * @FileName : Format_exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class Format_exam {

	public static void main(String[] args) {
		String name="sonoo";
		String sf1=String.format("name is %s", name);
		String sf2=String.format("value is %f", 32.33434);
		String sf3=String.format("value is %.5f", 32.33434);
		
		System.out.println(sf1);
		System.out.println(sf2);
		System.out.println(sf3);
		
	}

}
