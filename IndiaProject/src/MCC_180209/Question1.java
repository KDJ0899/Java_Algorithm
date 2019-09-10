package MCC_180209;

import java.util.Scanner;

class one_digit{
	int n;
	one_digit(){}
	one_digit(int n){
		this.n=n;
	}
	public void print() {
		switch(n){
		case 1:
			System.out.print("one");
			break;
		case 2:
			System.out.print("two");
			break;
		case 3:
			System.out.print("three");
			break;
		case 4:
			System.out.print("four");
			break;
		case 5:
			System.out.print("five");
			break;
		case 6:
			System.out.print("six");
			break;
		case 7:
			System.out.print("seven");
			break;
		case 8:
			System.out.print("eight");
			break;
		case 9:
			System.out.print("nine");
			break;
		}
	}
}
class ten_digit extends one_digit{
	int t;
	ten_digit(){}
	ten_digit(int n){
		super(n%10);
		this.t=n/10;
	}
	public void print() {
		switch(t){
		case 0:
			super.print();
			break;
		case 1:
			if(super.n==0)
				System.out.print("ten");
			else if(super.n==1)
				System.out.print("eleven");
			else if(super.n==2)
				System.out.print("twelve");
			else if(super.n==3)
				System.out.print("thirteen");
			else if(super.n==5)
				System.out.print("fifteen");
			else {
				super.print();
				System.out.print("teen");
			}
			break;
		case 2:
			System.out.print("twenty ");
			super.print();
			break;
		case 3:
			System.out.print("thirty ");
			super.print();
			break;
		case 4:
			System.out.print("fourty ");
			super.print();
			break;
		case 5:
			System.out.print("fifty ");
			super.print();
			break;
		case 6:
			System.out.print("sixty ");
			super.print();
			break;
		case 7:
			System.out.print("seventy ");
			super.print();
			break;
		case 8:
			System.out.print("eighty ");
			super.print();
			break;
		case 9:
			System.out.print("ninety ");
			super.print();
			break;
		}
	}
}

class hundred_digit extends ten_digit {
	int h;
	hundred_digit(){}
	hundred_digit(int n){
		super(n%100);
		this.h=n/100;
	}
	public void print() {
		switch(h){
		case 1:
			System.out.print("onehundred ");
			super.print();
			break;
		case 2:
			System.out.print("twohuderd ");
			super.print();
			break;
		case 3:
			System.out.print("threehuderd  ");
			super.print();
			break;
		case 4:
			System.out.print("fourhuderd ");
			super.print();
			break;
		case 5:
			System.out.print("fivehuderd ");
			super.print();
			break;
		case 6:
			System.out.print("sixhuderd ");
			super.print();
			break;
		case 7:
			System.out.print("sevenhuderd  ");
			super.print();
			break;
		case 8:
			System.out.print("eighthuderd ");
			super.print();
			break;
		case 9:
			System.out.print("ninethuderd ");
			super.print();
			break;
		}
	}
	
}
public class Question1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n<1||n>=1000)
			System.out.println("ivalid lange");
		else if(n/100!=0) {
			hundred_digit digit=new hundred_digit(n);
			digit.print();
		}
		else if(n/10!=0) {
			ten_digit digit=new ten_digit(n);
			digit.print();
		}
		else {
			one_digit digit=new one_digit(n);
			digit.print();
		}	
	}

}
