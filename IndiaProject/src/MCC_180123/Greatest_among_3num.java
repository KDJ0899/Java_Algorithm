package MCC_180123;

public class Greatest_among_3num {
	public static void main(String[] args) {
		int a=10,b=20,c=30;
		int max=a>b?(a>c?a:c):(b>c?b:c);
		System.out.println(max);
	}      
}
