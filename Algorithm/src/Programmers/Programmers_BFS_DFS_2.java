package Programmers;
/*
 * 프로그래머스 깊이/넓이 우선탐색 2번 문제 네트워크
 */
public class Programmers_BFS_DFS_2 {
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        int[] arr=new int[n];
        boolean t=false;
        for(int i=0; i<n;i++){
            t=false;
            for(int j=0; j<n;j++){
                if(computers[i][j]==1){
                    computers[i][j]=0;
                    computers[j][i]=0;
                    computers[j][j]=0;
                    if(arr[i]==0)
                        t=true;
                    arr[i]=1;
                    if(i!=j)
                        network(j,computers,arr);
                }
            }
            if(t)
                answer++;
        }
        return answer;
    }
    public static void network(int i,int[][] computers,int[] arr) {
        for(int j=0; j<computers[i].length;j++){
            if(computers[i][j]==1){
                computers[i][j]=0;
                computers[j][i]=0;
                computers[j][j]=0;
                arr[i]=1;
                arr[j]=1;
                network(j,computers,arr);
            }
        }
    }

}
