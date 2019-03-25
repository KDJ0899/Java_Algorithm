package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
  * @FileName : integerTriangle.java
  * @Project : Algorithm
  * @Date : 2019. 3. 25. 
  * @Author : Kim DongJin
  * @Comment :
 */
public class integerTriangle {
	static int max=0;
	public static int solution(int[][] triangle) {
		
		List<Node> sums=new ArrayList<Node>();
		sums.add(new Node(triangle[0][0],0));
        sums=DP(triangle,sums,1);
        
        Collections.sort(sums, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.sum-o1.sum;
			}
		});
        return sums.get(0).sum;
    }
	
	public static List<Node> DP(int[][] triangle,List<Node> sums,int i) {
		if(triangle.length==i) {
			return sums;
		}
		List<Node> newSums=new ArrayList<Node>();
		Node node;
		for(int a=0; a<sums.size(); a++) {
			node=sums.get(a);
			newSums.add(new Node(node.sum+triangle[i][node.j],node.j));
			newSums.add(new Node(node.sum+triangle[i][node.j+1],node.j+1));
		}
		return DP(triangle,newSums,i+1);
	
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

}

class Node{
	int sum;
	int j;
	
	public Node(int sum,int j ) {
		this.sum=sum;
		this.j=j;
	}
}
