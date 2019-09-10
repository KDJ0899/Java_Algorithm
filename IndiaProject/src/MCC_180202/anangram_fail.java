package MCC_180202;

import java.util.Scanner;

public class anangram_fail {
	String word;
	
	public anangram_fail() {}
	public anangram_fail(String word) {
		this.word=word;
	}
	
	public static int anag (String word) {
		char[] arr=new char[word.length()];
		int k=1,num=0,cont=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=word.charAt(i);
		}
		for(int i=1;i<arr.length;i++) {
			k*=i;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<k;j++ ) {
				System.out.print(arr[i]);
				for(int a=1;a<arr.length;a++){
					if((i+a+j)%arr.length==i)
						System.out.print(arr[(i+a+j+1)%arr.length]);
					else
						System.out.print(arr[(i+a+j)%arr.length]);
				}
				System.out.print(" ");
				num++;
				cont++;
				if(cont==6) {
					System.out.println();
					cont=0;
				}
			}
		}
		System.out.println();
		return num;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("INPUT: ");
		String word=sc.nextLine();
		System.out.print("OUTPUT: ");
		
		anangram_fail an=new anangram_fail(word);
		System.out.println("Total number of anagrams= "+anag(word));

	}

}
