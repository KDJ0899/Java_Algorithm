package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 1956번 운동 문제 풀이 완료.
 */
public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt(), INF = 10000 * 800 + 1, answer = INF;
        int[][] roadVals = new int[V][V];
        List<Integer>[] roads = new ArrayList[V];
        Queue<Integer> nextTown = new LinkedList<Integer>();
        boolean[] isVisited;

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            if (roads[a] == null) {
                roads[a] = new ArrayList<Integer>();
            }

            roads[a].add(b);
            roadVals[a][b] = sc.nextInt();
        }

        for (int i = 0; i < V; i++) {
            isVisited = new boolean[V];

            if (roads[i] != null) {
                nextTown.offer(i);
            }

            while (!nextTown.isEmpty()) {
                int n = nextTown.poll();

                if (roads[n] != null) {
                    if (!isVisited[n]) {
                        isVisited[n] = true;

                        for (int town : roads[n]) {
                            int value = roadVals[i][n] + roadVals[n][town];

                            if (roadVals[i][town] == 0 || roadVals[i][town] >= value) {
                                roadVals[i][town] = value;
                                nextTown.offer(town);
                            }
                        }
                    }
                }
            }

            if (roadVals[i][i] > 0) {
                answer = Math.min(answer, roadVals[i][i]);
            }
        }

        if (answer == INF)
            answer = -1;

        System.out.println(answer);

        sc.close();
    }
}
