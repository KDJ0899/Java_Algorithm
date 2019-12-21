package KakaoTest_2018;

import java.util.Arrays;
/**
 * 
 * 
 * @Package : OurAlgorism_October
 * @FileName : KakaoTest_2018_failPercent.java
 * @Author : KIM DONGJIN
 * @date : 2018. 10. 30. 
 *
 */
public class KakaoTest_2018_failPercent {
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] nowStage=new int[N+1];
        float[] percent=new float[N];
        int countStage=0;
        float max;
        int maxIndex=0;
        
        for(int i=0;i<stages.length;i++){
            nowStage[stages[i]-1]++;
        }
        for(int i=0; i<nowStage.length-1;i++) {
        	if(nowStage[i]!=0)
        		percent[i]=(float)nowStage[i]/(stages.length-countStage);
        	else
        		percent[i]=0;
        	countStage+=nowStage[i];	
        }
        
        for(int i=0;i<N;i++) {
        	max=-1;
        	for(int j=0;j<N;j++) {
        		if(percent[j]>max) {
        			max=percent[j];
        			maxIndex=j;
        		}
        	}
        	answer[i]=maxIndex+1;
        	percent[maxIndex]=-2;
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5,new int[] {1,1,1,1,1,2,1,1,1,1})));

	}

}
