package MCC180820;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPfoutServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(1205);
		Socket s=ss.accept();
		
		String str="Hello!!\nMy Name";
		byte[] b=str.getBytes();
		
		OutputStream o=s.getOutputStream();
		o.write(b);
		o.flush();
		ss.close();
		s.close();
	}

}
