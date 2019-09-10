package MCC_180201;

import java.io.*;

public class BufferesReaderExample {

	public static void main(String[] args) throws Exception {
		InputStreamReader r= new InputStreamReader(System.in);
		
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter yout name");
		String name=br.readLine();
		System.out.println("Welcome "+name);
	}
}
