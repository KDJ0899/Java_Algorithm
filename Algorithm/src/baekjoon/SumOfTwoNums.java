package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3273번 두 수의 합 문제 풀이 완료.
 */
public class SumOfTwoNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), left = 0, right = n - 1, answer = 0;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                answer++;
                left++;
            }else if (nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}