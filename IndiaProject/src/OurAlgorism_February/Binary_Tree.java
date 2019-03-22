package OurAlgorism_February;

import java.util.Scanner;
/**
 * 2018-02-04 PM.03:00~PM.07:31 자료구조 이진트리만들기(1.29~2.4 일주일과제)
 * 
 * @Package : OurAlgorism_February
 * @FileName : Binary_Tree.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 4. 
 *
 */
public class Binary_Tree {
	static int max_height=-1,del=0;
	static tree newNode=null;
	static class tree{
		int n;
		tree left;
		tree right;
		
		public tree() {}
		public tree(int n) {
			this.n=n;
		}
	}
	
	public static tree insertnode(tree top, int n) {
		if(top==null) {
			top=new tree(n);
		}
		else {
			tree newNode;
			if(n>top.n) {
				if(top.right==null) {
					newNode=new tree(n);
					top.right=newNode;
				}
				else
					insertnode(top.right, n);
			}
			else if(n<top.n) {
				if(top.left==null) {
					newNode=new tree(n);
					top.left=newNode;

				}
				else
					insertnode(top.left,n);
			}
			else {
				System.out.println("insert value is duplicate");
			}
		}
		return top;
	}
	
	public static tree deletenode(tree top,int n) {
				if(top.n==n) {
					if(top.left!=null) {
						top.left=l_sort(top.left);
						newNode.left=top.left;
						newNode.right=top.right;
						top=newNode;
					}
					else if(top.right!=null) {
						top.right=r_sort(top.right);
						newNode.left=top.left;
						newNode.right=top.right;
						top=newNode;
					}
					else {
						top=null;
					}
					del=1;
					return top;
				}
				else {
					if(n>top.n) {
						if(top.right!=null)
							top.right=deletenode(top.right, n);
						else
							del=0;
					}
					else {
						if(top.left!=null)
							top.left=deletenode(top.left, n);
						else
							del=0;
					}
					return top;
				}
	}
	
	public static tree l_sort(tree top) {
		if(top.right==null) {
			newNode=top;
			top=top.left;
			return top;
		}
		else {
			if(top.right.right==null) {
				if(top.right.left!=null) {
					newNode=top.right;
					top.right=top.right.left;
					return top;
				}
				else {
					newNode=top.right;
					top.right=null;
					return top;
				}
			}
			else {
				top=l_sort(top.right);
			}
		}
		return top;
		
	}
	public static tree r_sort(tree top) {
		if(top.left==null) {
			newNode=top;
			top=top.right;
			return top;
		}
		else {
			if(top.left.left==null) {
				if(top.left.right!=null) {
					newNode=top.left;
					top.left=top.left.right;
					return top;
				}
				else {
					newNode=top.left;
					top.left=null;
					return top;
				}
			}
			else {
				top=r_sort(top.left);
			}
		}
		return top;
		
	}
	public static void size(tree top,int hei) {
		if(top==null) 
			max_height=0;
		else {
			rightsize(top, hei);
			leftsize(top, hei);
		}
	}
	public static void rightsize(tree top,int hei) {
		if(top.right!=null) {
			hei++;
			size(top.right, hei);
		}
		else {
			if(hei>max_height)
				max_height=hei;
		}
	}
	public static void leftsize(tree top,int hei) {
		if(top.left!=null) {
			hei++;
			size(top.left, hei);
		}
		else {
			if(hei>max_height)
				max_height=hei;
		}
	}

	public static void printnode(tree top,int hei) {
		if(top==null)
			System.out.println("tree is null");
		else{
			rightnodeprint(top, hei);
			for(int i=1;i<hei;i++)
				System.out.print("   ");
			System.out.println(top.n);
			leftnodeprint(top, hei);
		}
	}
	public static void leftnodeprint(tree top,int hei) {
		if(top.left!=null) {
			hei++;
			printnode(top.left,hei);
		}
	}
	public static void rightnodeprint(tree top,int hei) {
		if(top.right!=null) {
			hei++;
			printnode(top.right,hei);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,value,hei=1,br=0;
		tree top=null;
		System.out.println("1:insert 2:delete 3:empty 4:size 5:print 6:break");
		while(true) {
			System.out.print("Enter the command:");
			n=sc.nextInt();
			switch(n) {
			case 1:
				System.out.print("Enter the insert value:");
				value=sc.nextInt();
				top=insertnode(top, value);
				break;
			case 2:
				if(top==null)
					System.out.println("Tree is empty");
				else {
					System.out.println("Enter the delete value:");
					value=sc.nextInt();
					del=0;
					top=deletenode(top, value);
					if(del==0) 
						System.out.println("Delete value don't exist in tree");
					else
						System.out.println("Sucsses Delete");
				}
				break;
			case 3:	
				if(top==null)
					System.out.println("Tree is empty");
				else
					System.out.println("Tree is not empty");
				break;	
			case 4:
				max_height=-1;
				size(top,hei);
				System.out.println("Tree size is "+max_height);
				break;
			case 5:
				printnode(top, hei);
				break;
			case 6:
				br=1;
				break;
			}
			if(br==1)
				break;
		}
		sc.close();
	}
}
