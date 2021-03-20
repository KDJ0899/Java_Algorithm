package baekjoon;

import java.util.Scanner;

/**
 * 백준 12852번 1로 만들기2 문제 풀이 완료
 */
public class MakeToOne2 {

    public static int[] dp, nextNum;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), idx = n;
        String answer = "" + n;
        nextNum = new int[n + 1];
        dp = new int[n + 1];

        caculate(n);
        System.out.println(dp[n]);

        while (dp[idx] != 0) {
            answer += " " + nextNum[idx];
            idx = nextNum[idx];
        }
        System.out.println(answer);
        sc.close();

    }

    public static int caculate(int n) {

        if (n == 1)
            return 0;

        if (dp[n] != 0)
            return dp[n];

        int divideThreeResult = Integer.MAX_VALUE, divideTwoResult = Integer.MAX_VALUE, minusResult;

        if (n % 3 == 0) {
            divideThreeResult = caculate(n / 3);
        }

        if (n % 2 == 0) {
            divideTwoResult = caculate(n / 2);
        }

        minusResult = caculate(n - 1);

        if (divideThreeResult < divideTwoResult) {
            if (divideThreeResult < minusResult) {
                dp[n] = divideThreeResult + 1;
                nextNum[n] = n / 3;
            } else{
                dp[n] = minusResult + 1;
                nextNum[n] = n - 1;
            }
        } else {
            if (divideTwoResult < minusResult) {
                dp[n] = divideTwoResult + 1;
                nextNum[n] = n / 2;
            } else{
                dp[n] = minusResult + 1;
                nextNum[n] = n - 1;
            }
        }
        return dp[n];
    }
}
