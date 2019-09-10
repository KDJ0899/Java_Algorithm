package MCC_180226;
/**
 * 자바 String 함수 예제1
 * 
 * @Package : MCC_180226
 * @FileName : String_Exam.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class String_Exam {

	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("Hello");
		sb.append("Java");
		System.out.println(sb);
		
		StringBuffer sb1=new StringBuffer("Hello");
		sb1.insert(1, "java");
		System.out.println(sb1);
		
		String s1="My name is kim my name is java";
		String replaceString=s1.replace("is", "was");
		System.out.println(replaceString);
		
		StringBuffer sb2=new StringBuffer("Hello");
		sb2.delete(1, 3);
		System.out.println(sb2);
		
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb3=new StringBuffer();
		System.out.println(sb3.capacity());
		sb3.append("Hello");
		System.out.println(sb3.capacity());
		sb3.append("Java is my favorite language");
		System.out.println(sb3.capacity());
		sb3.ensureCapacity(10);
		System.out.println(sb3.capacity());
		sb3.ensureCapacity(50);
		System.out.println(sb3.capacity());

	}

}
