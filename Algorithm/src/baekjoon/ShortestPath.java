package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1753번 최단 경로 문제 풀이 완료.
 */
public class ShortestPath{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V,E,start,a,b,cost,INF = 10 * 40000 + 1;
        Map<Integer,Integer>[] graph;
        Queue<Integer> nextVertex = new LinkedList<Integer>();
        int[] distance;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine()) - 1;
        graph = new HashMap[V];
        distance = new int[V];

        for(int i=0; i<V; i++){
            graph[i] = new HashMap<>();
            distance[i] = INF;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            cost = Integer.parseInt(st.nextToken());

            if(graph[a].containsKey(b))
                cost = Math.min(graph[a].get(b), cost);

            graph[a].put(b, cost);
        }

        nextVertex.add(start);
        distance[start] = 0;

        while(!nextVertex.isEmpty()){
            int current = nextVertex.poll();
            Map<Integer, Integer> edges = graph[current];
            int nowCost = distance[current];

            for(int v : edges.keySet()){
                if(distance[v] > edges.get(v) + nowCost ){
                    distance[v] = edges.get(v) + nowCost;
                    nextVertex.add(v);
                }
            }
        }


        for(int i=0; i<V; i++){
            if(distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
}