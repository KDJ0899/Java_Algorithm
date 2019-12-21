/**
 * 
 */
package KaKaoTest_2020;

import java.util.HashMap;
import java.util.Map;

/**
  * @FileName : PillarAndBeam.java
  * @Project : Algorithm
  * @Date : 2019. 12. 2.
  * @Author : Kim DongJin
  * @Comment :2020카카오 기둥과 보 문제.
  * 의문 : 기둥위에 보가 존재한 상태로 그 반대쪽에 보를 설치하는 것이 가능한가?
  * 	ㅡ ㅡ
  * 	 ㅣ
 */
public class PillarAndBeam {
	

	public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int x,y,material;
        Map<String, Boolean> structure = new HashMap<String, Boolean>();
        
        for(int i=0; i<build_frame.length; i++) {
        	x = build_frame[i][0];
        	y = build_frame[i][1];
        	material = build_frame[i][2];
        	
        	if(material==0) {// 건축물이 기둥인가?
        		if(build_frame[i][3]==0) {// 기둥을 생성하는가?
    				if(y==0 //바닥인가?
    						||(structure.containsKey(x+" "+y+" "+1)&&!structure.containsKey((x-1)+" "+y+" "+1))//밑에 보가 존재하면서, 보의 끝인가?
    						||(structure.containsKey(x-1+" "+y+" "+1)&&!structure.containsKey(x+" "+y+" "+1))
    						|| structure.containsKey(x+" "+(y-1)+" "+0))// 바닥이 아니면 밑에 기둥이 있는가? {
    					
    					structure.put(x+" "+y+" "+0, true);
    					
    				}       			
	    		else {//기둥을 제거하는가?
	    			if((structure.containsKey(x+" "+(y+1)+" "+1)&&structure.containsKey((x-1)+" "+(y+1)+" "+1))//위에 보가 존재하면서, 보의 끝이 아닌가?
	    					||(structure.containsKey(x-1+" "+(y+1)+" "+1)&&structure.containsKey(x+" "+(y+1)+" "+1))
	    					||structure.containsKey(x+" "+(y+1)+" "+0)) { //위에 기둥이 없는가?
	    				structure.put(x+" "+y+" "+0, false);
	    			}
	    						
	    			
	    		}
        	}
        	
        	else {
        		if(build_frame[i][3]==0) {// 보를 생성하는가?
        			if(y>0||structure.containsKey(x+" "+(y-1)+" "+0) //바닥보다 위인가?
        					||structure.containsKey((x+1)+" "+(y-1)+" "+0)//보 끝에 기둥이 있는가?
        					||(structure.containsKey((x-1)+" "+y+" "+1)&&structure.containsKey((x+1)+" "+y+" "+1 ))){//보 양쪽끝에 다른 보가 있는가?
						structure.put(x+" "+y+" "+1, true);
        			}
        		}
        		else {// 보를 제거하는가?
        			//보 옆에 있는 보에 기둥이 있는가? 보 위에 기둥이 있지만 아래에 기둥이 있는가?
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
