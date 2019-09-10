package MCC_180220;
/**
 * 
 * 
 * @Package : MCC_180220
 * @FileName : example_static.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 20. 
 *
 */
public class example_static {

	public static void main(String[] args) {
		student s1=new student();
		s1.showdata();
		student s2=new student();
		s2.showdata();
		student.b++;
		s1.showdata();

	}
}
class student{
	int a;
	static int b;
	student(){
		b++;
	}
	public void showdata() {
		System.out.println("Value of a="+a);
		System.out.println("Value of b="+b);
	}
	
}
