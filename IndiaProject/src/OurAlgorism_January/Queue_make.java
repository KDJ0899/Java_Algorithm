package OurAlgorism_January;

import java.util.Scanner;

import OurAlgorism_January.Stack_make.Stack;
/**
 * 큐 만들기(1.29~2.4 일주일과제)
 * 
 * @Package : OurAlgorism_January
 * @FileName : Queue_make.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 29. 
 *
 */
public class Queue_make {
	static class queue{
		int vlaue;
		queue next;
		
		public queue() {}
		public queue(int n) {vlaue=n;}
	}
	
	public static queue push(queue top,int n) {
		if(empty(top)==0) {
			top=new queue(n);
			return top;
		}
		else {
			queue new_q=new queue(n);
			queue temporary_q=top;
			while(true){
				if(temporary_q.next==null) {
					temporary_q.next=new_q;
					return top;
				}
				else {
					temporary_q=temporary_q.next;
				}
			}
		}
	}
	public static queue pop(queue top) {
		if(empty(top)==0) {
			System.out.println("Queue is empty!!!");
			return top;
		}
		else {
			System.out.println(top.vlaue);
			return top.next;
		}
	}
	public static void size(queue top) {
		int cont=0;
		while(true) {
			if(empty(top)==0) {
				System.out.println("Size is "+cont);
				break;
			}
			else {
				cont++;
				if(top.next==null) {
					System.out.println("Size is "+cont);
					break;
				}
			}
		}
	}
	public static int empty(queue top) {
		if(top==null)
			return 0;
		else return 1;
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int command,n,end=0;
		queue top = null;
		System.out.println("1:Push,2:Pop,3:Size,4:Empty,5:The End");
		while(true) {
			System.out.println("Enter the command:");
			command=sc.nextInt();
			
			switch(command) {
			case 1:n=sc.nextInt();top=push(top,n);break;
			case 2:top=pop(top);break;
			case 3:size(top);break;
			case 4:if(empty(top)==0)System.out.println("Stack is empty");else System.out.println("Stack is not empty");break;
			default:end=1;break;
			}
			if(end==1)
				break;
		}

	}

}
