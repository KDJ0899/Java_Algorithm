package MCC_180307;

import java.util.Scanner;

public class Exam_3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] Sentence=new String[100];
		String[] palindrome = new String[100];
		StringBuffer sb = null;
		char[] word;
		boolean Break=false;
		int i=0,j=0;
		while(true) {
			Sentence[i]=sc.next();
			word=Sentence[i].toCharArray();
			for(char W:word) {
				if(W=='?'||W=='.'||W=='!') {
					Break=true;
					Sentence[i]=Sentence[i].substring(0, word.length-1);
				}
			}
			sb=new StringBuffer(Sentence[i]);
			if(Sentence[i].equals(sb.reverse().toString())) {
				palindrome[j]=Sentence[i];
				j++;
			}
			i++;
			if(Break==true)
				break;
		}
		for(int a=0;a<j;a++) {
			System.out.print(palindrome[a]+"  ");
		}
		System.out.println();
		System.out.println(j);

	}

}
