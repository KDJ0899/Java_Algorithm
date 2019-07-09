package MCC180823;

public class MultithreadingDemo extends Thread /*implements Runnable*/  {
	public void run() {
		try {
			System.out.println("Thread "+Thread.currentThread().getId()+" is Running");
		}
		catch(Exception e) {
			System.out.println("Exception is caught");
		}
	}
}
