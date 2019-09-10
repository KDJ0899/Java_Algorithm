/**
 * @Summary   : 
 * @Package : MCC_180213
 * @FileName : squre_matrix.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 13.  
 * 
 */
package MCC_180213;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 자바 연습문제 배열 90도 회전하기
 * 
 * @Package : MCC_180213
 * @FileName : squre_matrix.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 13. 
 * 
 */
abstract class shape {
	int[][] arr;
	public void rotate(int[][] matrix) {}
}
class matrix extends shape{
	public matrix() {}
	public matrix(int n){
		arr=new int[n][n];
	}
	public void rotate(int[][] matrix) {
		int x=arr.length-1,y=0;
		for(int i=0;i<arr.length;i++) {
			x=arr.length-1;
			for(int j=0;j<arr.length;j++) {
				arr[i][j]=matrix[x][y];
				x--;
			}
			y++;
		}
	}
}
public class squre_matrix {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=0;
		int[][] matrix=new int[n][n];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		shape obj=new matrix(n);
		obj.rotate(matrix);
		System.out.println("Original Matrix:");
		for(int i=0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("Rotated Matrix:");
		for(int i=0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(obj.arr[i]));
		}
		sum=obj.arr[0][0]+obj.arr[0][obj.arr.length-1]+obj.arr[obj.arr.length-1][0]+obj.arr[obj.arr.length-1][obj.arr.length-1];
		System.out.println("Sum="+sum);


	}

}

