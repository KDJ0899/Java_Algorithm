package baekjoon;

import java.util.Scanner;

/**
 * 백준 11479번 서로 다른 부분 문자열 갯수 문제 풀이 완료.
 */
public class DifferentSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                String temp1 = str.substring(i+1);
                String temp2 = str.substring(i, j+1);
                if(!temp1.contains(temp2)){
                    count++;    
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}
