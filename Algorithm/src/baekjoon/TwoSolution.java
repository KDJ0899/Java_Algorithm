package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470 두 용액 문제 풀이 (투포인터)
 */
public class TwoSolution {
    public static void main(String[] args) throws NumberFormatException, IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        int x = 0, y = n - 1, min = Integer.MAX_VALUE, nowValue, answerX = 0, answerY = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        while (x < y) {
            nowValue = Math.abs(nums[x] + nums[y]);

            if (min > nowValue) {
                min = nowValue;

                answerX = nums[x];
                answerY = nums[y];
            }

            if (Math.abs(nums[x]) < Math.abs(nums[y])) {
                y--;
            } else {
                x++;
            }
        }

        System.out.println(answerX + " " + answerY);
    }
}
