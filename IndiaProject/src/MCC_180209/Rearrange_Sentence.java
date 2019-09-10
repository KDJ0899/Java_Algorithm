package MCC_180209;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * 
 * @Package : MCC_180209
 * @FileName : Rearrange_Sentence.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 09. 
 *
 */
public class Rearrange_Sentence {

	public static void main(String[] args) {
		String[] arr=new String[500];
		char[] cha=new char[500];//
		Scanner sc=new Scanner(System.in);
		int i=0,k=0,br=0;
		while(true) {
			arr[i]=sc.next();
			cha=arr[i].toCharArray();
			for(k=0;k<cha.length;k++) {
				if(cha[k]=='.'||cha[k]=='?'||cha[k]=='!') {
					br=1;
					arr[i]=arr[i].substring(0, cha.length-1);
					break;
				}
				if(cha[k]<'A'||cha[k]>'Z') {
					br=2;
					break;
				}
			}
			i++;
			if(br==1||br==2)
				break;
		}
		if(br==2) 
			System.out.println("invalid word!");
		else {
			String[] new_arr=new String[i];
			for(int j=0;j<i;j++) {
				System.out.print(arr[j]+" ");
				new_arr[j]=arr[j];
			}
			System.out.println();
			System.out.println("Length: "+i);
			Arrays.sort(new_arr);
			for(int j=0;j<i;j++)
				System.out.print(new_arr[j]+" ");
		}
	}
}
