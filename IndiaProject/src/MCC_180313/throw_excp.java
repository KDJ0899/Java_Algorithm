package MCC_180313;


public class throw_excp {
	static void avg() {
		try {
			throw new ArithmeticException("demo");
		}
		catch(ArithmeticException e) {
			System.out.println("Exception caught");
		}
	}

	public static void main(String[] args) {
		avg();

	}

}
