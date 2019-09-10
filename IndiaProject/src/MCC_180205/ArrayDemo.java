package MCC_180205;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] array=new int[7];
		for(int i=0;i<array.length;i++) 
			array[i]=i+1;
		
		for(int i=0;i<array.length;i++) 
			System.out.println("Array["+i+"]="+array[i]);
		System.out.println("Length of array="+array.length);
	}
}
