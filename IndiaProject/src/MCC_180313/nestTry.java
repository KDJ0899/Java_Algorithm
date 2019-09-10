package MCC_180313;

public class nestTry {

	public static void main(String[] args) {
		try {
			int arr[]= {1,2};
			try {
				arr[1]=3/0;
			}
			catch(ArithmeticException e) {
				System.out.println("Divide by zero");
			}
			arr[4]=2;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds");
		}

	}

}
