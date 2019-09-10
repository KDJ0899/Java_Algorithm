package MCC_180307;

import java.util.Scanner;

public class Exam_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("N=");
		int n=sc.nextInt();
		if(n<3||n>8) {
			System.out.println("Invalid number!");
			return;
		}
		String[] sentence=new String[n];
		int max=0;
		sentence[0]=sc.nextLine();
		for(int i=0;i<n;i++) {
			System.out.print("Team "+(i+1)+":");
			sentence[i]=sc.nextLine();
			if(max<sentence[i].length())
				max=sentence[i].length();
		}
		for(int i=0;i<max;i++) {
			for(int j=0;j<n;j++) {
				if(sentence[j].length()<=i)
					System.out.print("     ");
				else {
					System.out.print(sentence[j].charAt(i)+"    ");
				}
			}
			System.out.println();
		}

	}

}
