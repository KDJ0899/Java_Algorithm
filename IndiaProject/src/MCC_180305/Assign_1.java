package MCC_180305;

import java.util.Scanner;

/**
 * 
 * 
 * @Package : MCC_180305
 * @FileName : Assign_1.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 5. 
 *
 */
public class Assign_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		System.out.println(input);
		String[] sentence=new String[10];
		int cont=0;
		char[] senten=input.toCharArray();
		String[] word=new String[100];
		int[] vowel=new int[10];
		int[] words=new int[10];
		sentence[0]="";
		System.out.println("Sentence         No.of.Vowels      No.of Words");
		for(int i=0;i<senten.length;i++) {
			if(senten[i]=='?'||senten[i]=='.'||senten[i]=='!') {
				while(true) {
					if(i>=senten.length-1)
						break;
					if(senten[i+1]!=' ')
						break;
					i++;
				}
				word=sentence[cont].split("\\s");
				for(String w:word){
					words[cont]++;
				}
				System.out.println(cont+1+"                     "+vowel[cont]+"               "+words[cont]);
				cont++;
				sentence[cont]="";
			}
			else {
				if(senten[i]=='a'||senten[i]=='e'||senten[i]=='i'||senten[i]=='o'||senten[i]=='u') {
					vowel[cont]++;
				}
				if(senten[i]==' ') {
					if(senten[i+1]==' ')
						continue;
				}
				sentence[cont]+=senten[i];
			}
		}
		System.out.println("Sentence        No.of words/vowels");
		for(int i=1;i<=cont;i++) {
			System.out.print(i+"                ");
			for(int j=0;j<vowel[i-1];j++)
				System.out.print("VVV");
			System.out.println();
			System.out.print("                 ");
			for(int j=0;j<words[i-1];j++) {
				System.out.print("W");
			}
			System.out.println();
		}

	}

}
