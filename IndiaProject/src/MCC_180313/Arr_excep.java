package MCC_180313;

public class Arr_excep {

	public static void main(String[] args) {
		try {
			int arr[]= {1,2};
			arr[2]=3/0;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds");
		}
		catch(ArithmeticException e) {
			System.out.println("Divide by zero");
		}
	}

}
