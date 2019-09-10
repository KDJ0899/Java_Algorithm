package MCC_180305;
/**
 * lastindexof 는 indexof와 반대로 뒤에서 부터 탐색.
 * 
 * @Package : MCC_180305
 * @FileName : lastIndexOf.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class lastIndexOf {

	public static void main(String[] args) {
		String s1="This is index of example";
		int index1=s1.lastIndexOf("is",1);
		System.out.println(index1);
	}
}
