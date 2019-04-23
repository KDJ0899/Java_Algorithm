package MCC180823;

public class secondThread extends Thread  {
	public void run() {
		try {	
			System.out.println("Second Thread is Running");
		}
		catch(Exception e) {
			System.out.println("Exception is caught");
		}
	}

}
