package MCC_180202;

import java.util.Scanner;

public class anagram_HomeWork {
	static int line=0;
	public static void anagram(char[] word,char[] digit,int[] index,int position) {
		int duplicate=0;
		position++;
		for(int i=0;i<word.length;i++) {
			duplicate=0;
			for(int j=0;j<position;j++ ) {
				if(index[j]==i) {	
					duplicate=1;
				}
			}
			if(duplicate==0) {
				digit[position]=word[i];
				index[position]=i;
				if(position>=word.length-1) {
					for(int j=0;j<word.length;j++) {
						System.out.print(digit[j]);
					}
					System.out.print("  ");
					line++;
					if(line%6==0)System.out.println();
					return;	
				}
				else {
					anagram(word,digit,index,position);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input:");
		String word=sc.nextLine();
		System.out.println("Output:");
		char[] arr=new char[word.length()];
		char[] digit=new char[word.length()];
		int[] index=new int[word.length()];
		int position;

		for(int i=0;i<arr.length;i++) {
			arr[i]=word.charAt(i);
		}
		for(int i=0;i<arr.length;i++) {
			position=0;
			digit[position]=arr[i];
			index[position]=i;
			anagram(arr, digit, index, position);
		}
		System.out.println("Total number of anagrams= "+ line);	
		sc.close();
	}
}
