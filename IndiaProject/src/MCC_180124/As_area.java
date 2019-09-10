package MCC_180124;

import java.util.Scanner;

public class As_area {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1=circle, 2=squre, 3=sphere");
		System.out.println("Enter number:");
		int k=sc.nextInt();
		System.out.println("enter Value:");
		int n=sc.nextInt();
		
		switch(k){
			case 1:System.out.println("circle area: "+n*n*Math.PI);break;
			case 2:System.out.println("square area:"+n*n);break;
			case 3:System.out.println("sphere: "+4*n*n*Math.PI);break;
			default:System.out.println("Invalid");
		}
		sc.close();
	}

}
