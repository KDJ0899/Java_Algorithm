package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 11725번 트리의 부모찾기 문제 풀이 완료
 */
public class FindParentOfTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        List<Integer>[] tree = new ArrayList[n+1];
        int[] answer = new int[n+1];

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(tree[x] == null){
                tree[x] = new ArrayList<>();
            }

            if(tree[y] == null){
                tree[y] = new ArrayList<>();
            }

            tree[x].add(y);
            tree[y].add(x);
        }

        Queue<Integer> nextNode = new LinkedList<Integer>();
        nextNode.offer(1);
        answer[1] = 0;

        while(!nextNode.isEmpty()){
            int node = nextNode.poll();

            for(int num : tree[node]){
                if(answer[num] == 0){
                    answer[num] = node;
                    nextNode.add(num);
                }
            }
        }

        for(int i=2; i<n+1; i++){
            System.out.println(answer[i]);
        }
        
    }
}
