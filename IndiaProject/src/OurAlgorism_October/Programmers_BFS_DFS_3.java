package OurAlgorism_October;

/*
 * 프로그래머스 깊이/넓이 우선탐색 3번 문제 단어변환
 */
public class Programmers_BFS_DFS_3 {
	int min=51;
    public int solution(String begin, String target, String[] words) {
          int answer = 0;
          boolean[] t=new boolean[words.length];
          dfs(begin.toCharArray(),target,words,t,1);
          if(min==51)
              min=0;

          return min;
      }
    public void dfs(char[] begin,String target,String[] words,boolean[] t,int answer) {
        char[] wordChar;
        int dif;
        boolean[] t1=new boolean[words.length];
        for(int i=0;i<words.length;i++) {
            t1[i]=t[i];
        }
        for(int i=0;i<words.length;i++){
            if(t1[i])
                continue;
            dif=0;
            wordChar=words[i].toCharArray();
            for(int j=0;j<words[i].length();j++){
                if(begin[j]!=wordChar[j]) {
                    dif++;
                    if(dif>1)
                        break;
                }
            }
            if(dif==1) {
                t1[i]=true;
                if(words[i].equals(target)) {
                    if(min>answer)
                        min=answer;
                    return;
                }
                dfs(words[i].toCharArray(),target,words,t1,answer+1);
            }
        }  
    }

}
