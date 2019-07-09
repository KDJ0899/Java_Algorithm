package MCC180823;

public class thirdThread extends Thread  {
	public void run() {
		try {
			System.out.println("Third Thread is Running");
		}
		catch(Exception e) {
			System.out.println("Exception is caught");
		}
	}

}
