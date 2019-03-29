package MCC_180305;
/**
 * Indexof함수 해당 문장이 몇번째 인덱스에 있는지 찾는 함수.
 * 
 * @Package : MCC_180305
 * @FileName : IndexOf_exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class IndexOf_exam {

	public static void main(String[] args) {
		String s1="This is index of example";
		int index1=s1.indexOf("is");
		int index2=s1.indexOf("index");
		System.out.println(index1+"  "+index2);
		
		int index3=s1.indexOf("is", 4);
		System.out.println(index3);
		
		int index4=s1.indexOf('s');
		System.out.println(index4);

	}

}
