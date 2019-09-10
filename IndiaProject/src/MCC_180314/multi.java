package MCC_180314;

public class multi extends Thread {
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String[] args) {
		multi m=new multi();
		m.run();

	}

}
