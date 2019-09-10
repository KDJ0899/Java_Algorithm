package MCC_180313;

public class excp {

	public static void main(String[] args) {
		int a,b,c;
		try {
			a=0;
			b=10;
			c=b/a;
		}
		catch(ArithmeticException e){
			System.out.println("Devided by zero");
		}
		System.out.println("after exception");

	}

}
