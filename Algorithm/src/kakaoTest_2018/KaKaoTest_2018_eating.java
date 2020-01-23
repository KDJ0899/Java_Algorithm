package kakaoTest_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @Package : OurAlgorism_October
 * @FileName : KaKaoTest_2018_eating.java
 * @Author : KIM DONGJIN
 * @date : 2018. 10. 30. 
 *
 */
public class KaKaoTest_2018_eating {
	public static int solution(int[] food_times, long k) {
		int len  = food_times.length;
        int[] sorting = food_times.clone();
        
        long tmp;
        int same,sub,sum = 0;

        for(int i=0; i<len; i++) {
        	sum+=food_times[i];
        }
 
        if(k>=sum)
        	return -1;       
        
        Arrays.sort(sorting);
        
        for(int i=0; i<food_times.length;) {
        	same=0;
        	tmp = (int) (k/len);
        	if(tmp>=sorting[i]) {
        		sub=sorting[i];
        		k-=len*sorting[i];
        		
        		for(int j=0; j<food_times.length; j++) {
        			food_times[j]-=sub;
        			sorting[j]-=sub;
        			
        			if(food_times[j]==0) {
        				same++;
        			}
        		}
        		len-=same;
        		i+=same;
        	}
        	else if(tmp<sorting[i]) {        		
        		for(int a=0; a<food_times.length;a++) {
 	        		for(int j=0; j<food_times.length;j++) {
	        			if(k==0&&food_times[j]>0) {
	        				return j+1;
	        			}
	        			if(food_times[j]>0) {
	        				food_times[j]--;
	        				k--;
	        			}	        		
	        		}
        		}
        		break;
        	}
        }
        return -1;
    }
	
	 public static int solution1(int[] food_times, long k) {
	        int tmp=0;
	        int empty=0;
	        int len=food_times.length;
	        for(int i=0;i<k;i++) {
	        	empty=0;
	        	while(food_times[tmp%len]==0) {
	        		tmp++;
	        		empty++;
	        		if(empty==len)
	        			return -1;
	        	}
	        	
	    		food_times[tmp%len]--;
	    		
	    		tmp++;
	        }
	        empty=0;
	        while(food_times[tmp%len]==0) {
        		tmp++;
        		empty++;
        		if(empty==len)
        			return -1;
        	}
	        
	        return tmp%len+1;
	    }
	 public static class Node{
		 int index;
		 int value;
		 
		 public Node() {
			 index=0;
			 value=0;
		 }
		 
		 public Node(int index,int value) {
			 this.index=index;
			 this.value=value;
		 }
	 }
	 
	 public static int realSolution(int[] food_times, long k) {
		 List<Node> list=new ArrayList<>();
		 
		 for(int i=0; i<food_times.length; i++) {
			 list.add(new Node(i+1,food_times[i]));
		 }
		 
		 Collections.sort(list,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {		
				return o1.value-o2.value;
			}
		});
		 
		 int len=list.size();
		 int i=0, sub=0, diff=0;
		
		 while(list.size()>i) {
			 
			 diff=list.get(i).value-sub;
			 
			 if(k/len>=diff) {
	
				 k-=diff*len;
				 sub=list.get(i).value;
				 i++;
				 len--;

				 continue;
			 }
			 else {

				 int remain=(int) (k%len);

				 List<Integer> indexList=new ArrayList<>();
				 for(int j=i; j<list.size(); j++) {
					 indexList.add(list.get(j).index);
				 }
				 Collections.sort(indexList);
				 return indexList.get(remain);
			 }
		 }
		 
		 return -1;
	 }
	public static void main(String[] args) {
		System.out.println(realSolution(new int[] {2,2,2,4,2},11));
	}
}
