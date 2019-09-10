package MCC_180124;

import java.util.Scanner;

public class As_binarynumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=n,count=0,sw=0,max=0,num=0;
		int[] arr=new int[1000];
		while(true) {
			if(k==1) {
				arr[count]++;
				n=(int) (n-Math.pow(2, count));
				if(count==0)
					n=0;
				k=n;
				sw++;
				if(count>max)
					max=count;
			}
			else if(k==0) {
				if(count==0)
					break;
				arr[count]++;
				n=(int) (n-Math.pow(2, count));
				k=n;
				sw++;
				if(count>max)
					max=count;
			}
			if(sw==0)
				count++;
			else {
				count=0;
				sw=0;
				if(k/2>0)
					count++;
			}
			if(k>1)
				k=k/2;
			if(n<=0)
				break;
		}
		for(int i=max;i>=0;i--) {
			System.out.print(arr[i]);
			if(arr[i]==1)
				num++;
		}
		System.out.println();
		System.out.println("NO.Of 1's:"+num);
		if(num%2==0)
			System.out.println("Evil number");
		else
			System.out.println("Not Evil number");
		sc.close();
	}

}
