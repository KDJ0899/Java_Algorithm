package kakaoTest_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 2018 카카오 블라인드 테스트 후보키문제
 * 
 * @Package : OurAlgorism_October
 * @FileName : KakaoTest_2018_candidateKey.java
 * @Author : KIM DONGJIN
 * @date : 2018. 11. 7. 
 *
 */
public class KakaoTest_2018_candidateKey {
	static int max=0;
	
	public static int solution(String[][] relation) {
		
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> combination=new ArrayList<>();
        
        recursion(result, relation,combination,0);
        ArrayList<ArrayList<Integer>> newResult=new ArrayList<>();
        
        for(int i=1;i<max+1;i++) {
        	for(int j=0;j<result.size();j++) {
        		if(result.get(j).size()==i)
        			newResult.add(result.get(j));
        	}
        }
        int dupl=0;
        
        System.out.println(newResult.toString());
        for(int i=0;i<newResult.size();i++) {
        	for(int j=i+1;j<newResult.size();j++) {
        		dupl=0;
        		for(int x=0;x<newResult.get(i).size();x++) {
        			for(int y=0;y<newResult.get(j).size();y++) {
        				if(newResult.get(i).get(x)==newResult.get(j).get(y))
        					dupl++;
        			}
        		}
        		if(dupl==newResult.get(i).size()) {
        			newResult.remove(j);
        			j--;
        		}
        	}
        }
        System.out.println(newResult.toString());
        return newResult.size();
    }
	
	
	public static void recursion(ArrayList<ArrayList<Integer>> result, String[][]relation,ArrayList<Integer> combination,int start) {
		
		ArrayList<Integer> newCombi;
		boolean pass;
		HashSet<String> set;
		String[][] key;
		
		 for(int i=start;i<relation[0].length;i++) {
			 start=i;
			 pass=false;
			 newCombi=(ArrayList<Integer>) combination.clone();
			 set=new HashSet<String>();
			 
			 for(int x=0;x<result.size();x++) {
					 if(newCombi.equals(result.get(x))) {
						 pass=true;
				 }
			 }
			 if(pass)
				 continue;

			newCombi.add(i);
			key=new String[relation.length][newCombi.size()];
			
	        for(int j=0;j<relation.length;j++) {
	        	for(int x=0;x<newCombi.size();x++) {
	        		key[j][x]=relation[j][newCombi.get(x)];
	        	}
	        	set.add(Arrays.toString(key[j]));
	        }
	        
	        if(set.size()==relation.length) {
	        	result.add(newCombi);
	        	if(newCombi.size()>max)
	        		max=newCombi.size();
	        }
	        else {
	        	recursion(result,relation,newCombi,start+1);
	        }
	        
	     }
	}

	public static void main(String[] args) {
		String[][] relation= {{"100","ryan","music","2","1"},{"200","apeach","math","2","2"},{"300","tube","computer","3","3"},{"400","con","computer","4","4"},{"500","muzi","music","3","5"}
		,{"600","apeach","math","1","6"}};
		System.out.println(solution(relation));

	
	}
	
    public int RealSolution(String[][] relation) {
        int n = relation.length;       
        int m = relation[0].length;     
        ArrayList<Integer> list = new ArrayList<Integer>();

        
        for(int i=1; i<(1<<m); i++) {
            Set<String> s = new HashSet<String>();
            
            for(int j=0; j<n; j++) {
                String now = "";
                
                for(int k=0; k<m; k++) {
                    
                    if( (i&(1<<k)) > 0 ) {
                        now+=relation[j][k];
                    }
                }
                s.add(now);
            }
            if(s.size()==n&&possi(list,i)) list.add(i);
        }
        //System.out.println(list.size());
        return list.size();
    }
    public static boolean possi(ArrayList<Integer> list, int now) {
        for(int i=0; i<list.size(); i++) {
            
            if((list.get(i)&now)==list.get(i)) {
                return false;
            }
        }
        return true;
    }

}
