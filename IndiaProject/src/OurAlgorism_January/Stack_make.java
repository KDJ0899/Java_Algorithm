package OurAlgorism_January;

import java.util.Scanner;
/**
 * 스택만들기(1.29~2.4 일주일과제)
 * 
 * @Package : OurAlgorism_January
 * @FileName : Stack_make.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 30. 
 *
 */
public class Stack_make {
	static class Stack{
	int value;
	Stack next;
	
	public Stack(int n) {
		value=n;
	}
	public Stack() {}
	
	}
	
	public static Stack push(Stack top,int n) {
		if(empty(top)==0) {
			top=new Stack();
			top.value=n;
			return top;
		}
		else {
			Stack under=new Stack(n);
			under.next=top;
			return under;
		}
		
	}
	public static Stack pop(Stack top) {
		if(empty(top)==0) {
			System.out.println("Stack is empty!!");
			return top;
		}
		else {
			System.out.println(top.value);
			return top.next;
		}
	}
	public static void size(Stack top) {
		int cont=0;
		if(empty(top)==0) {
			System.out.println("size is "+cont);
		}
		else{
			while(true) {
				cont++;
				if(top.next==null) {
					System.out.println("size is "+cont);
					break;
				}
				else {
					cont++;
					top=top.next;
				}
			}
		}
	}
	public static int empty(Stack top) {
		if(top==null)
			return 0;
		else
			return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int command,n,end=0;
		Stack top = null;
		System.out.println("1:push,2:pop,3:size,4:empty,5:the end");
		while(true) {
			System.out.println("enter the command:");
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
