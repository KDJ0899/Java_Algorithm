package MCC_180207;

import java.util.Arrays;
import java.util.Scanner;

public class DECODED_MESSAGE {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[600];
		int i=0,sum=0,cont=0;
		char decode;
		while(true) {
			arr[i]=sc.nextInt();
			if(arr[i]<0)
				break;
			if(arr[i]/10!=0) {
				arr[i+1]=arr[i]%10;
				arr[i]=arr[i]/10;
				i++;
			}
			i++;
		}
		i--;
		int[] reverse=new int[i+1];
		for(int j=0;j<reverse.length;j++) {
			reverse[j]=arr[i];
			i--;
		}
		System.out.println("Reverse message:");
		System.out.println(Arrays.toString(reverse));
		System.out.println("Decoded message:");
		for(int j=0;j<reverse.length;j++) {
			sum=sum*10+reverse[j];
			if(sum==32||(65<=sum&&122>=sum)) {
				if(65<=sum&&90>=sum)
					cont++;
				decode=(char) sum;
				sum=0;
				System.out.print(decode);
			}
		}
		System.out.println();
		for(int j=0;j<cont;j++)
			System.out.print("*");
	}
}
