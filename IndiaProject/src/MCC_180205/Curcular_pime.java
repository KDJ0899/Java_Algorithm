package MCC_180205;

public class Curcular_pime {

	public static void main(String[] args) {
		int count=0,k,digit=0,prime=1,line=0;
		System.out.println("CIRCULAR PRIME NUMBER IS:");
		for(int num=2;num<2000;num++) {
			k=num;
			digit=0;
			count=0;
			prime=1;
			while(true) {
				if(k==0)
					break;
				digit++;
				k/=10;
			}
			for(int i=0;i<digit;i++) {
				for(int j=2;j<num;j++) {
					if(num%j==0) {
						count++;
						break;
					}
				}
				if(count!=0) {
					prime=0;
				}
				k=num%10;
				num/=10;
				num=(int) (num+k*Math.pow(10, digit-1));
			}
			if(prime==1) {
				System.out.print(num+" ");
				line++;
				
			}
			if(line==10) {
				System.out.println();
				line=0;
			}
		}
	}
}
