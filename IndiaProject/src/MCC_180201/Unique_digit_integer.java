package MCC_180201;

import java.util.Scanner;

public class Unique_digit_integer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("m");
		int m=sc.nextInt();
		System.out.println("n");
		int n=sc.nextInt();
		int a,k,cor=0,cont=0,num=0;
		int[] arr=new int[10];
		if(m>30000||n>30000)
			System.out.println("OUT OF RANGE");
		else {
			System.out.println("THE UNIQUE-DIGIT INTEGER ARE:");
			for(int i=m;i<=n;i++) {
				k=i;
				cor=0;
				a=0;
				while(true) {
					arr[a]=k%10;
					if(k/10!=0) {
						k/=10;
						for(int j=a;j>=0;j--) {
							if(arr[j]==k%10) {
								cor=1;
								break;
							}
						}
					}
					else {
						for(int j=a-1;j>=0;j--) {
							if(arr[j]==k%10) {
								cor=1;
								break;
						}
					}	
						if(cor==0) {
							System.out.print(i+" ");
							cont++;
							num++;
						}
						if(cont==10) {
							System.out.println();
							cont=0;
						}
						break;
					}
					a++;
					
				}
				
			}
			System.out.println("FREQUENCY OF UNIQUE-DIGIT INTEGER IS: "+num);
		}
	

	}

}
