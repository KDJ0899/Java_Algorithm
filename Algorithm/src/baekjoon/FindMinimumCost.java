package baekjoon;

import java.util.*;

/**
 *  백준 11779번 최소비용 구하기2 문제 풀이 완료. 
 */
public class FindMinimumCost{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int INF = 1000 * 100000 + 1;
        Map<Integer, Integer>[] road = new HashMap[n];
        Queue<Integer> nextCities = new LinkedList<Integer>();
        int[] destinations = new int[n], parents = new int[n];
        Stack<Integer> route = new Stack<>();

        for(int i=0;  i<n; i++){
            road[i] = new HashMap<>();
            destinations[i] = INF;
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();

            road[a].put(b, c);
        }

        int start = sc.nextInt() - 1, end = sc.nextInt() - 1;
        nextCities.add(start);
        destinations[start] = 0;

        while(!nextCities.isEmpty()){
            int current = nextCities.poll();
            Map<Integer, Integer> cities = road[current];

            for(int city : cities.keySet()){
                int cost = destinations[current] + cities.get(city);
                if(destinations[city] > cost){
                    destinations[city] = cost;
                    parents[city] = current;
                    if(city != end)
                        nextCities.add(city);
                }
            }
        }

        int a = end;
        route.push(a + 1);
        while(a != start){
            route.push(parents[a] + 1);
            a = parents[a];
        }

        System.out.println(destinations[end]);
        System.out.println(route.size());
        while(!route.isEmpty()){
            int city = route.pop();
            System.out.print(city+" ");
        }

        sc.close();
    }
}