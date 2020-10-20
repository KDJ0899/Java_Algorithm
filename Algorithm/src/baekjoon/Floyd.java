package baekjoon;

import java.util.Scanner;

/**
 * 
  * @FileName : Floyd.java
  * @Project : Algorithm
  * @Date : 2020. 10. 20. 
  * @Author : Kim DongJin
  * @Comment : 백준 11404번 플로이드 문제 풀이.
 */
public class Floyd {
    static int[][] city;
    static int n, m;
    public static final int INF = 1000000000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a, b, c;

        n = sc.nextInt(); 
        m = sc.nextInt(); 
        city = new int[n][n];

        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(i == j) continue;
                city[i][j] = INF;
            }
        }

        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(city[a-1][b-1] == 0 || city[a-1][b-1] > c)
                city[a-1][b-1] = c;
        }
         

        floydWarshall();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static void floydWarshall() {
        for(int k = 0; k < n; k++) {
            for(int i=0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    city[i][j] = Math.min(city[i][k] + city[k][j], city[i][j]);
                }
            }
        }
    }
}
