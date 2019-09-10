package MCC_Android_180127;
//클래스 만들어 보기. 
public class student {
	
	public student() {}

	public student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	int id;
	String name;
	
	public static void main(String[] args) {
		student s1=new student();
		s1.id=111;
		s1.name="korean";
		
		System.out.println(s1.id);
		System.out.println(s1.name);
		
		student s2=new student();
		s2.id=222;
		s2.name="Aryan";
		
		System.out.println(s2.id+" "+s2.name);
		
		student s3=new student(333,"Kim");
		System.out.println(s3.id+" "+s3.name);
	}
}
