package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
// 백준 1927번 최소 힙 문제 풀이
public class MinHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if (queue.isEmpty()) {
                    bw.write("0\n");
                 } else {
                    bw.write(queue.poll() + "\n");
                 }
            } else {
                queue.add(a);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
