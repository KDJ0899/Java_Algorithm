package MCC180820;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TCPfoutClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket s=new Socket("127.0.0.1",1205);
		
		byte[] b=new byte[10000];
		InputStream i=s.getInputStream();
		
		FileOutputStream fo=new FileOutputStream("C:\\Users\\user\\Desktop\\test.txt");
		BufferedOutputStream bo=new BufferedOutputStream(fo);
		
		i.read(b);
		bo.write(b);
		bo.flush();
		s.close();
	}

}
