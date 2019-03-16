package OurAlgorism_October;
/*
 * 프로그래머스 완전탐색 1번 문제 모의고사
 */
public class Programmers_BruteForceSearch_1 {
	public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] result;
        int[] first={1,2,3,4,5};
        int[] second={2,1,2,3,2,4,2,5};
        int[] third={3,3,1,1,2,2,4,4,5,5};
        int f=0,s=0,t=0,max=0,index=0;
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%first.length])
                f++;
            if(answers[i]==second[i%second.length])
                s++;
            if(answers[i]==third[i%third.length])
                t++;
        }
        max=f;
        if(max<s)
            max=s;
        if(max<t)
            max=t;
        if(max==f)
            answer[index++]=1;
        if(max==s)
            answer[index++]=2;
        if(max==t)
            answer[index++]=3;
        
        result=new int[index];
        for(int i=0;i<index;i++){
            result[i]=answer[i];
        }
        return result;
    }

}
