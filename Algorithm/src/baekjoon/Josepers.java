package baekjoon;

import java.util.Scanner;
/**
 * 백준 1158번 조세퍼스 문제
 * 
 * @Package : OurAlgorism_February
 * @FileName : Virus.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class Josepers {

	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();// N�� M�� �Է¹���
		int k=0,j;
		int[] arr=new int[N];
		for(int i=0; i<N;i++) {// N���� ��ȣ�� �迭�� ����.
			arr[i]=i+1;
		}
        System.out.print("<");
		for(int i=0;i<N;i++){
			j=0;
			while(true) {
				if(arr[k]==-1) {
					j--;
				}
				if(j==M-1)//�־��� M��°�� �����Ҷ����� loop�� ����
					break;
				k++;
				k=k%N;
				j++;
			}
			System.out.print(arr[k]);
			arr[k]=-1;//��µ� ��ȣ�� �迭�ȿ� -1�� �Է�.
			if(i!=N-1)
				System.out.print(", ");
		}
		System.out.print(">");
	}

}