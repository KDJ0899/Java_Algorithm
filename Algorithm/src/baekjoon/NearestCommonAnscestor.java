package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  백준 3584번 가장 가까운 공통 조상 문제 풀이.
 */
public class NearestCommonAnscestor{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt(), a, b;
        int[] parents;
        Set<Integer> anscestor;
        
        for(int i=0; i<testCase; i++){
            int n = sc.nextInt();
            parents = new int[n+1];
            anscestor = new HashSet<>();
            
            for(int j=0; j<n-1; j++){
                a = sc.nextInt();
                b = sc.nextInt();
                parents[b] = a;
            }

            a = sc.nextInt();
            b = sc.nextInt();

            while(a != 0){
                anscestor.add(a);
                a = parents[a];
            }
            
            while(!anscestor.contains(b)){
                b = parents[b];
            }

            System.out.println(b);
        }
    }
}