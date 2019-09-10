package MCC_180201;

import java.util.Scanner;

public class Prime_palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("m ");
		int m = sc.nextInt();
		System.out.print("n ");
		int n = sc.nextInt();

		int prime = 0, k, a, cont = 0,num_cont=0;
		;
		int[] arr = new int[4];
		if (m > 3000 || n > 3000)
			System.out.println("OUT OF RANGE");
		else
			for (int i = m; i <= n; i++) {
				prime = 0;
				k = i;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						prime = 1;
						break;
					}
				}
				if (prime == 0) {
					for (a = 0; a < 4; a++) {
						arr[a] = k % 10;
						k = k / 10;
						if (k == 0)
							break;
					}
					if (a == 0) {
						System.out.print(i + " ");
						cont++;
						num_cont++;
						if (cont == 10) {
							System.out.println();
							cont = 0;
						}
					} else if (a == 1) {
						if (arr[0] == arr[1]) {
							System.out.print(i + " ");
							cont++;
							num_cont++;
							if (cont == 10) {
								System.out.println();
								cont = 0;
							}
						}
					} else if (a == 2) {
						if (arr[0] == arr[2]) {
							System.out.print(i + " ");
							cont++;
							num_cont++;
							if (cont == 10) {
								System.out.println();
								cont = 0;
							}
						}
					} else if (a == 3) {
						if (arr[0] == arr[3] && arr[1] == arr[2]) {
							System.out.print(i + " ");
							cont++;
							num_cont++;
							if (cont == 10) {
								System.out.println();
								cont = 0;
							}
						}
					}
				}
			}
		System.out.println();
		System.out.println("FREQUENCY OF PRIME PALINDROMEINTEGERS "+num_cont);
	}
}
