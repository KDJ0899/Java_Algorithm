package MCC_180314;
class BankAcoount{
	private volatile int balance;
	public BankAcoount(int b) {
		balance =b;
	}
	public BankAcoount() {
		balance=0;
	}
	synchronized public int getBanlance() {
		return balance;
	}
	synchronized public int withdraw(int w) {
		int b=getBanlance();
		if(w<=b) {
			balance=balance-w;
			return w;
		}
		else return 0;
	}
}
class WithdrawAccount implements Runnable{
	private BankAcoount acc;
	private int amount;
	public WithdrawAccount() {
		acc=null;
		amount=0;
	}
	public WithdrawAccount(BankAcoount acc,int amount) {
		this.acc=acc;
		this.amount=amount;
	}
	public void run() {
		int w;
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Balance before"+Thread.currentThread().getName()+"Withdraw:"+acc.withdraw(amount));
			w=acc.withdraw(amount);
			System.out.println("Balance after"+Thread.currentThread().getName()+"Withdraw: "+acc.getBanlance());
		}
	}
}
public class TestBankAcoount {

	public static void main(String[] args) {
		BankAcoount b=new BankAcoount(1000);
		WithdrawAccount w=new WithdrawAccount(b, 10);
		Thread wt1=new Thread(w);
		wt1.setName("T1");
		Thread wt2=new Thread(w);
		wt2.setName("T2");
		wt1.start();
		wt2.start();
	}
}
