package MCC180917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPsender implements Runnable {

	private static DatagramSocket ds=null;
	private static DatagramPacket dp=null;
	private static byte[] b=new byte[1000];

	private static BufferedReader inputLine = null;
	private static boolean closed = false;

	public static void main(String[] args) throws UnknownHostException {

		// The default port.
		int portNumber = 9999;
		// The default host.
		String host = "localhost";
		InetAddress ip=InetAddress.getByName("127.0.0.1");

		if (args.length < 2) {
			System.out.println("Usage: java MultiThreadChatClient <host> <portNumber>\n"
		+ "Now using host="+ host+ ", portNumber="+ portNumber);
		} else {
			host = args[0];
			portNumber = Integer.valueOf(args[1]).intValue();
		}

		/*
		 * Open a socket on a given host and port. Open input and output
		 * streams.
		 */
		try {
			ds = new DatagramSocket();
			dp= new DatagramPacket(b, b.length,ip,portNumber);
			inputLine = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host "
							+ host);
		}

		/*
		 * If everything has been initialized then we want to write some data to
		 * the socket we have opened a connection to on the port portNumber.
		 */
		if (ds != null&&dp != null) {
			try {

				/* Create a thread to read from the server. */
				new Thread(new MultiThreadChatClient()).start();
				while (!closed) {
					b=inputLine.readLine().trim().getBytes();
					dp= new DatagramPacket(b, b.length,ip,portNumber);
					ds.send(dp);
				}
				/*
				 * Close the output stream, close the input stream, close the
				 * socket.
				 */
				ds.close();
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}
	}

	
	public void run() {
		/*
		 * Keep on reading from the socket till we receive "Bye" from the
		 * server. Once we received that then we want to break.
		 */
		String responseLine;
		try {
			ds.receive(dp);
			while ((responseLine = b.toString()) != null) {
				System.out.println(responseLine);
				if (responseLine.indexOf("*** Bye") != -1)
					break;
			}
			closed = true;
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}
	}
}
