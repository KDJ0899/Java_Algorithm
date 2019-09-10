package MCC_180314;

public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	RunnableDemo(String name){
		threadName=name;
		System.out.println("Creating "+threadName);
	}
	public void run() {
		System.out.println("Running "+threadName);
		try {
			for(int i=4;i>0;i--) {
				System.out.println("thread:"+threadName+", "+i);
				Thread.sleep(1);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Thread"+threadName+" interrupted");
		}
		System.out.println("Thread "+threadName+" exting");
	}
	public void start() {
		System.out.println("Starting "+threadName);
		if(t==null) {
			t=new Thread(threadName);
			t.start();
		}
	}

	public static void main(String[] args) {
		RunnableDemo r1=new RunnableDemo("Thread-1");
		r1.run();
		RunnableDemo r2=new RunnableDemo("Thread-2");
		r2.run();

	}

}
