package MCC_180220;

import java.util.Scanner;
/**
 * 
 * 
 * @Package : MCC_180220
 * @FileName : sentence_number.java
 * @Author : KIM DONGJIN
 * @date : 2018. 2. 20. 
 *
 */
public class sentence_number {
	static String[] word=new String[50];
	static int[] frequency=new int[50];
	static String[] dupl_word=new String[word.length];
	static int length;
	
	static {
		length=0;
		System.out.println("Enter number of sentences");
	}
	public static void duplicate() {
		int n=0,dupl=0,tmp;
		String tmps;
		for(int i=0;i<length;i++) {
			dupl=0;
			for(int j=0;j<n;j++) {
				if(word[i].equals(word[j])) {
					dupl=1;
					break;
				}
			}
			if(dupl==1)
				continue;
			for(int j=i+1;j<length;j++) {
				if(word[i].equals(word[j])) {
					frequency[n]++;
				}
			}
			dupl_word[n]=word[i];
			for(int j=0;j<n;j++) {
				if(frequency[n]<frequency[j]) {
					tmps=dupl_word[n];
					tmp=frequency[n];
					for(int k=n;k>j;k--) {
						frequency[k]=frequency[k-1];
						dupl_word[k]=dupl_word[k-1];
					}
					dupl_word[j]=tmps;
					frequency[j]=tmp;
				}
			}
			n++;
		}
		for(int i=0;i<n;i++) {
			System.out.println(dupl_word[i]+"                            "+(frequency[i]+1));
		}
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n<1||n>4) {
			System.out.println("Invalid Range");
			return;
		}
		int br=0;
		char[] cha=new char[50];
		System.out.println("Enter sentences");
		for(int i=0;i<n;i++) {
			br=0;
			while(true) {
				word[length]=sc.next();
				cha=word[length].toCharArray();
				for(int k=0;k<cha.length;k++) {
					if(cha[k]=='?'||cha[k]=='.') {
						br=1;
						break;
					}
				}
				if(br==1) {
					word[length]=String.valueOf(cha, 0, cha.length-1);
					length++;
					break;
				}
				length++;
			}
		}
		System.out.println("Total number of words :   "+length);
		System.out.println("WORD                       FREQUENCY");
		duplicate();
	}
}
