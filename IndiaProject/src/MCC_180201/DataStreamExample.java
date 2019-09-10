package MCC_180201;

import java.io.*;
import java.util.Formatter;

public class DataStreamExample {

	public static void main(String[] args) throws IOException {
		DataInputStream in= new DataInputStream(System.in);
		Formatter fmt=new Formatter();
		
		System.out.println("Enter P1");
		int f=Integer.parseInt(in.readLine());
		System.out.println("Enter p2");
		int g=Integer.parseInt(in.readLine());
		double area=3.14*f*g;
		fmt.format("%7.2f", area);
		System.out.println("Area of eclipse "+area);
		System.out.println(fmt);
	}

}
