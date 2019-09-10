package OurAlgorism_January;

import java.util.Scanner;

public class number_trianglle {
/**
 * 18.1.27 PM.11:20 태일이형과 같이 숫자삼각형에서 최대값을 가지는 경로 찾기 (백준 1932번)(실패)
 * 
 * @Package : OurAlgorism_January
 * @FileName : number_trianglle.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 27. 
 *
 */
static class Triangle {
	int value;
	Triangle left;
	Triangle right;
	public Triangle() {
	}
}

public static Triangle made_Triangle(Triangle start_Tri,int num,int height,int i,int start,int end) {
	int k=i;
	int[] path=new int[height-1];
	if(i==1) {
		start_Tri.value=num;
		return start_Tri;
	}
	else if(i==start) {
		Triangle path_tri=new Triangle();
		Triangle new_tri=new Triangle();
		path_tri=start_Tri;
		for(int j=0;j<height-1;j++) {
			path[j]=1;//1이 왼쪽으로 내려오기
			
		}
		for(int j=height-2;j>=0;j--) {
			path_tri=made(path_tri,new_tri,path,j);
		}
		return start_Tri;
	}
	return start_Tri;
}

public static Triangle made(Triangle start_Tri,Triangle new_tri,int[] path,int j) {
	
	if(j!=0) {
		if(path[j]==1)
			return start_Tri.left;
		else
			return start_Tri.right;
	}
	else {
		if(path[j]==1) {
			start_Tri.left=new_tri;
			return start_Tri;
		}
		else {
			start_Tri.right=new_tri;
			return start_Tri;
		}	
	}	
}

	public void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int num=0,height=1,start=1,end=1,i;
		Triangle start_Tri=new Triangle();
		for(i=1;i<=n;i++) {
			num=sc.nextInt();
			start_Tri=made_Triangle(start_Tri, num, height, i, start, end);
			if(i==start) {
				height++;
				start+=height;
				end+=height+1;
			}
		}
		System.out.println(start_Tri.value);
		System.out.println(start_Tri.left.value);
		
		
	}

}
