package baekjoon;

import java.util.Scanner;

/**
 * 백준 1956번 운동 문제 풀이.
 */
public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(), E = sc.nextInt(), INF = 10000*400+1, answer = INF;
        int[][] road = new int[V][V]; 

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            road[a-1][b-1] = sc.nextInt();
        }

        for(int i=0; i<V; i++){
            road[i][i] = INF;
            for(int j=0; j<V; j++){
                for(int k=0; k<V; k++){
                    if(road[i][k] > 0 && road[k][j] > 0)
                        road[i][j] = Math.min(road[i][j], road[i][k]+road[k][j]);
                }
            }
            answer = Math.min(answer, road[i][i]);
        }

        if(answer == INF ) answer = -1;
        
        System.out.println(answer);

        sc.close();
    }
}
