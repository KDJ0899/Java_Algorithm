package MCC180823;

public class MainThread extends Thread {

	public MainThread(String string) {
		super(string);
	}
	public void run() {
		if(Thread.currentThread().getName()=="Main") {
			System.out.println("Main is Start");
		}
		for(int i=0;i<3;i++) {
			try {
					if(Thread.currentThread().getName()!="Main") {
						Thread.sleep((int)Math.random());
						System.out.println(Thread.currentThread().getName()+" is running");
					}
				}
			catch(Exception e) {
				System.out.println("Exception is caught");
			}
		}
		if(Thread.currentThread().getName()=="Main") 
			System.out.println("Main is finish");
		else
			System.out.println(getName()+" is finish");
	}
	public static void main(String[] args) {
		
		MainThread main=new MainThread("Main");
		MainThread First=new MainThread("First");
		MainThread Second=new MainThread("Second");
		MainThread Third=new MainThread("Third");
		main.start();
		First.start();
		Second.start();
		Third.start();
	}
}
