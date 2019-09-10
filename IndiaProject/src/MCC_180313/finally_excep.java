package MCC_180313;

public class finally_excep {

	public static void main(String[] args) {
		int a[]=new int[2];
		System.out.println("out of try");
		try {
			System.out.println("Access invalid element"+a[2]);
		}
		finally {
			System.out.println("finally is always executed");
		}

	}

}
