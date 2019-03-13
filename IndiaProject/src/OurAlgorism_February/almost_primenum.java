package OurAlgorism_February;

import java.util.Scanner;
/**
 * ���ǼҼ� ���� 1456������ (18.2.26~3.4 �˰��� ���� Ǯ��),��Ÿ�ӿ���
 * 
 * @Package : OurAlgorism_February
 * @FileName : almost_primenum.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 26. 
 *
 */
public class almost_primenum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long m=sc.nextLong();
		int cont=0,k=2,a=0;
		boolean prim=true;
		long[] arr;
	    arr=new long[10000000];
	    boolean[] not_prime=new boolean[10000000];
		long alPr=1;
		for(long i=2;i<=m;i++) {
			if(not_prime[(int)i]) {
				i++;
				continue;
			}
			if(i*i>m) {
				break;
			}
			prim=true;
			for(long j=2;j<i;j++) {
				if(i%j==0) {
					prim=false;
					break;
				}
			}
			if(prim==true) {
				arr[a]=i;
				a++;
			}
		}
		if(arr[0]==0) {
			System.out.println(cont);
			return;
		}
		for(int i=0;i<a;i++) {
			alPr=arr[i];
			while(true) {
				alPr*=arr[i];
				if(alPr>m)
					break;
				if(alPr>=n)
					cont++;
			}
		}
		System.out.println(cont);
	}
}
