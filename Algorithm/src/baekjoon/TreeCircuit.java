package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 2263번 트리 순회 문제 풀이 완료
public class TreeCircuit {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] inOrder = br.readLine().split(" ");
        String[] postOrder = br.readLine().split(" ");

        makeTree(inOrder, postOrder);
    }

    public static void makeTree(String[] inOrder, String[] postOrder) {
        if (inOrder.length <= 0 || postOrder.length <= 0) {
            return;
        }

        String rootNode = postOrder[postOrder.length - 1];

        System.out.print(rootNode + " ");

        int rootNum = 0;

        for(int i = 0 ; i<inOrder.length; i++){
            if(inOrder[i].equals(rootNode)){
                rootNum = i;
                break;
            }
        }

        makeTree(Arrays.copyOfRange(inOrder, 0, rootNum), Arrays.copyOfRange(postOrder, 0, rootNum));
        makeTree(Arrays.copyOfRange(inOrder, rootNum + 1, inOrder.length),
                Arrays.copyOfRange(postOrder, rootNum, postOrder.length - 1));

        return;
    }
}
