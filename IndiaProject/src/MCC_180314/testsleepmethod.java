package MCC_180314;

public class testsleepmethod extends Thread {
	public void run() {
		for(int i=1;i<5;i++) {
			try{Thread.sleep(500);}catch(InterruptedException e) {System.out.println(e);}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		testsleepmethod t1=new testsleepmethod();
		testsleepmethod t2=new testsleepmethod();
		
		t1.run();
		t2.run();
	}

}
