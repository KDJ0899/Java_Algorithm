package kakaoTest_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @Package : OurAlgorism_October
 * @FileName : KakaoTest_2018_searchRoad.java
 * @Author : KIM DONGJIN
 * @date : 2018. 11. 7. 
 *
 */
public class KakaoTest_2018_searchRoad {
	static int a=0;
	public static class Node{
		
		int x;
		int y;
		int index;
		Node left;
		Node right;
		
		public Node() {
			left=null;
			right=null;
		}
		public Node(int x, int y, int index){
			this.x=x;
			this.y=y;
			this.index=index;
			left=null;
			right=null;
		}
		
	}
	
	public static int[][] solution(int[][] nodeinfo) {
		
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> list =new ArrayList<>();
        
        for(int i=0; i<nodeinfo.length; i++) {
        	list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        
        Collections.sort(list,new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.y-o1.y;
			}
        	
        });
        
        Node root=list.get(0);
        for(int i=1; i<list.size(); i++) {
        	makeTree(root,list.get(i));
        }
        
        preorder(root,answer);
        System.out.println(Arrays.toString(answer[0]));
        a=0;
        postorder(root,answer);
        System.out.println(Arrays.toString(answer[1]));
        
        
        return answer;
    }
	
	public static void makeTree(Node root, Node node) {
		if(root.x<node.x) {
			if(root.right!=null)
				makeTree(root.right, node);
			else
				root.right=node;
		}
		else {
			if(root.left!=null)
				makeTree(root.left, node);
			else
				root.left=node;
		}
	}
	
	public static void preorder(Node root,int[][] answer) {
		answer[0][a]=root.index;
		a++;
		if(root.left!=null)preorder(root.left,answer);
		if(root.right!=null)preorder(root.right,answer);
	}
	
	public static void postorder(Node root,int[][] answer) {
		if(root.left!=null)postorder(root.left,answer);
		if(root.right!=null)postorder(root.right,answer);
		answer[1][a]=root.index;
		a++;
	}
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {
			{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		})));

	}

}
