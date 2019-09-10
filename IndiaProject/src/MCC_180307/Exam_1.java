package MCC_180307;

import java.util.Scanner;
/**
 * 
 * 
 * @Package : MCC_180307
 * @FileName : Exam_1.java
 * @Author : KIM DONGJIN
 * @date : 2018. 3. 7. 
 *
 */
public class Exam_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] arr=new String[100];
		String[] StEnVowelWord=new String[100];
		char[] word;
		int i=0,cont=0;
		boolean[] StEnVowel = new boolean[100];
		boolean br = false;
		while(true){
			arr[i]=sc.next();
			arr[i]=arr[i].toUpperCase();
			word=arr[i].toCharArray();
			if((word[0]=='A'||word[0]=='E'||word[0]=='O'||word[0]=='I'||word[0]=='U')
					&&(word[word.length-1]=='A'||word[word.length-1]=='E'
					||word[word.length-1]=='O'||word[word.length-1]=='I'
					||word[word.length-1]=='U'))
			{
				StEnVowelWord[cont]=arr[i];
				cont++;
				StEnVowel[i]=true;
			}
					
			for(char w:word){
				if(w=='.'||w=='?'||w=='!'){
					if((word[0]=='A'||word[0]=='E'||word[0]=='O'||word[0]=='I'||word[0]=='U')
							&&(word[word.length-2]=='A'||word[word.length-2]=='E'
							||word[word.length-2]=='O'||word[word.length-2]=='I'
							||word[word.length-2]=='U'))
					{
						StEnVowelWord[cont]=arr[i].substring(0, word.length-1);
						cont++;
						StEnVowel[i]=true;
					}
					if(cont!=0)
						arr[i]=arr[i].substring(0, word.length-1);
					br=true;
					break;
				}
			}
			if(br)
				break;
			i++;
		}
		System.out.println("NUMBER OF WORDS BEGINNING AND ENDING " +
				"WITH A VOWEL="+cont);
		for(int j=0;j<cont;j++){
			System.out.print(StEnVowelWord[j]+" ");
		}
		for(int j=0;j<=i;j++){
			if(StEnVowel[j]==true)
				continue;
			System.out.print(arr[j]+" ");
		}
		sc.close();
	}

}
