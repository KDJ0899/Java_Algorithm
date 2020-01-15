package baekjoon;

import java.util.Scanner;
/**
 * 18.01.27 AM 01:25 인도에서 태일이형과 deque구현하기. (baekjoon)
 * 
 * @Package : OurAlgorism_January
 * @FileName : deque_make.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 27. 
 *
 */
class deque{
	deque(){
	}
	deque(int n){
		value=n;
	}
	int value=0;
	deque front;
	deque next;
}

public class deque_make {
	public static deque push_frontX(deque a,deque b){
		if(empty(a)!=1) { 
			b.next=a;
			a.front=b;
			return b;
		}
		else {
			a=new deque();
			a.value=b.value;
			return a;
		}
	}
	public static deque push_backX(deque c,deque b) {
		if(empty(c)!=1) {
			c.next=b;
			b.front=c;
			return b;
		}
		else {
			c=new deque();
			c.value=b.value;
			return c;
		}
	}
	public static deque pop_front(deque a) {
		if(empty(a)==1) {
			System.out.println(-1);
			return a;
		}
		else {
			System.out.println(a.value);
			if(a.next!=null)
				a.next.front=null;
			a=a.next;
//			if(b!=null)
//				b.front=null;
			return a;
		}
	}
	public static deque pop_back(deque c) {
		if(empty(c)==1) {
			System.out.println(-1);
			return c;
		}
		else {
			System.out.println(c.value);
			/*deque b=new deque();*/
			if(c.front!=null)
				c.front.next=null;
			c=c.front;
			/*if(b!=null)
				b.next=null;*/
			return c;
		}
	}
	public static int size(deque a) {
		int size=0;
		while(empty(a)!=1) {
			a=a.next;
			size++;
			if(a==null)
				break;
		}
		return size;
	}
	public static int empty(deque a) {
		if(a==null)
			return 1;
		else
			return 0;
	}
	public static int front(deque a) {
		if(empty(a)==1)
			return -1;
		else 
			return a.value;
	}
	public static int back(deque c) {
		if(empty(c)==1)
			return -1;
		else
			return c.value;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int val;
		String oper;
		deque a = null;
		deque b=new deque();
		deque c = null;
		for(int i=0; i<n; i++) {
			oper=sc.next();
			b=new deque();
			switch(oper) {
			case "push_front":
				val=sc.nextInt();
				b.value=val;
				a=push_frontX(a, b);
				if(a.next==null)
					c=a;
				break;
			case "push_back":
				val=sc.nextInt();
				b.value=val;
				c=push_backX(c, b);
				if(c.front==null)
					a=c;
				break;
			case "pop_front":
				a=pop_front(a);
				break;
			case "pop_back":
				c=pop_back(c);
				if(c==null)
					a=null;
				break;
			case "empty":
				System.out.println(empty(a));
				break;
			case "size":
				System.out.println(size(a));
				break;
			case "front":
				System.out.println(front(a));
				break;
			case "back":
				System.out.println(back(c));
				break;
			default:
				System.out.println("invalid");
			}
		}
	}
}
