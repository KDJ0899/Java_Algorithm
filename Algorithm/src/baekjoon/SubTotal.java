package baekjoon;

import java.util.Scanner;
/**
 * 백준 1806번 부분합 문제 풀이 완료.
 */
public class SubTotal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        int left = 0, right = 0, answer = Integer.MAX_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sum = nums[left];

        while (left < n) {
            if(right - left + 1 < answer){
                if(sum >= target){
                    answer = right - left + 1;
                    sum -= nums[left];
                    left++;
                } else{
                    right++;
                    if(right == n)
                        break;
                    sum += nums[right];
                }
            }else{
                sum -= nums[left];
                left++;
            }
        }

        if(answer == Integer.MAX_VALUE)
            answer = 0;

        System.out.println(answer);

        sc.close();
    }
}
