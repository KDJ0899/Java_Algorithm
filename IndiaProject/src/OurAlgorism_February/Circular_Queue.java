package OurAlgorism_February;

import java.util.Scanner;

import MCC_180124.switch_example;
/**
 * 2018.02.04 PM.01:21 자료구조 원형큐 만들기(1.29~2.4 일주일과제)
 * 
 * @Package : OurAlgorism_February
 * @FileName : Circular_Queue.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 4. 
 *
 */

public class Circular_Queue {
	static int Que_Size=5;
	
	static int[] CirQ=new int[Que_Size];
	static int front=0;
	static int rear=0;
	
	public static void put(int n) {
		if(front==(rear+1)%Que_Size) {
			System.out.println("CircularQueue is full");
			return;
		}
		CirQ[rear]=n;
		rear++;
		if(rear==Que_Size) {
			rear=0;
		}
	}
	public static void  get(){
		if(front==rear) {
			System.out.println("CircularQueue is empty");
			return;
			}
		System.out.println("result method get():"+CirQ[front]);
		front++;
	}
	public static void empty() {
		if(front==rear)
			System.out.println("CircularQueue is empty");
		else
			System.out.println("CircularQueue is not empty");
	}
	public static void size() {
		int size=0;
		int f=front,r=rear;
		while(true) {
			if(f%Que_Size==r%Que_Size)
				break;
			size++;
			f=(f+1)%Que_Size;
		}
		System.out.println("CircularQueue size is: "+size);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int input,n,bre=0;
		System.out.println("1.put 2.get 3.empty 4.size 5.break");
		while(true) {
			System.out.print("Enter the command:");
			input=sc.nextInt();
			switch(input) {
			case 1:
				System.out.print("please enter the value:");
				n=sc.nextInt();
				put(n);
				break;
			case 2:
				get();
				break;
			case 3:
				empty();
				break;
			case 4:
				size();
				break;
			case 5:
				bre=1;
				break;
			}
			if(bre==1)
				break;
		}
		

	}

}
