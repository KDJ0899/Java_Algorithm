package OurAlgorism_October;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @Package : OurAlgorism_October
 * @FileName : KakaoTest_2018_matchingPoint.java
 * @Author : KIM DONGJIN
 * @date : 2018. 11. 8. 
 *
 */
public class KakaoTest_2018_matchingPoint {
	
	public static class link{
		String Address;
		String Body;
		List<String> links;
		int Index;
		double matchingPoint;
		
		public link(String Address, String Body, int Index) {
			this.Address=Address;
			this.Body=Body;
			this.Index=Index;
			this.matchingPoint=0;
		}
	}
	

    public static int solution(String word, String[] pages) {
        int answer = -1;
        List<link> list= new ArrayList<>();
        Map<String,Integer> points=new HashMap<>();
        
        makeList(pages, list);
        makeLinks(list);
        countPoint(word,list,points);
        
        
        double linkPoint;
        
        for(int i=0; i<list.size();i++) {
        	
        	linkPoint=0;
        	
        	for(int j=0; j<list.get(i).links.size(); j++) {
                if(points.get(list.get(i).links.get(j))!=null)
        		    linkPoint+=points.get(list.get(i).links.get(j));
        	}
        	
        	linkPoint/=list.get(i).links.size();
        	
        	list.get(i).matchingPoint=linkPoint+points.get(list.get(i).Address);
        	
        }
        
        Collections.sort(list,new Comparator<link>() {

			@Override
			public int compare(link o1, link o2) {
				
				return (int) (o2.matchingPoint-o1.matchingPoint);
			}
		});
       for(int i=0; i<list.size(); i++) {
    	   System.out.println(list.get(i).matchingPoint);
       }
       for(int i=1; i<list.size(); i++) {
        	if(list.get(i-1).matchingPoint==list.get(i).matchingPoint) {
        		answer=Math.min(list.get(i-1).Index, answer);
        	}
        	else{
        		break;
            }
        }
       if(answer!=-1)
       	return answer;
       
       return list.get(0).Index;
    }
    
    private static void countPoint(String word, List<link> list,Map<String,Integer> points) {
		char[] charArr;
		String tmp;
		int point=0;
		word=word.toLowerCase();
    	for(int i=0; i<list.size(); i++) {
    		charArr=list.get(i).Body.toCharArray();
    		tmp="";
    		point=0;
    		
    		for(int j=0; j<charArr.length; j++) {
    			if((charArr[j]>='A'&&charArr[j]<='Z')||(charArr[j]>='a'&&charArr[j]<='z')) {
    				tmp+=charArr[j];	
    			}
    			else {
    				tmp=tmp.toLowerCase();
    				if(tmp.equals(word)) {
    					point++;
    				}
    				tmp="";
    			}
    		}
    		points.put(list.get(i).Address, point);
    	}
		
	}

	public static void makeList(String[] pages, List<link> list) {
    	 String page,Address,Body;
         String[] strArr;
         
         for(int i=0; i<pages.length; i++) {
         	page=pages[i];
         	strArr=page.split("<meta property='og:url' content=\"");
         	page=strArr[1];
         	strArr=page.split("\"/>");
         	Address=strArr[0];
         	strArr=page.split("<body>");
         	page=strArr[1];
         	strArr=page.split("</body>");
         	Body=strArr[0];
         	
         	list.add(new link(Address, Body, i));
         	
         }
    }
    
    public static void makeLinks(List<link> list) {
    	String body,tmp;
        String[] strArr,spl;
        for(int i=0; i<list.size(); i++) {
        	List<String> links=new ArrayList<>();
        	
        	body=list.get(i).Body;
        	strArr=body.split("<a href=\"");
        	for(int j=0; j<strArr.length; j++) {
                if(strArr[j].length()<7)
        			continue;
        		tmp=strArr[j].substring(0, 8);
        		if(tmp.equals("https://")) {
        			spl=strArr[j].split("\">");
        			links.add(spl[0]);
        			spl[0]="";
        			strArr[j]=String.join("",String.join("", spl).split("</a>"));
        			
        		}
        	}
        	list.get(i).links=links;
        	list.get(i).Body=String.join("", strArr);
        }
    }
    
    
	public static void main(String[] args) {
		String s="<html lang='ko' xml:lang='ko' xmlns='http://www.w3.org/1999/xhtml'> <head>"+
		  "<meta charset='utf-8'>"+
		 "<meta property='og:url' content=\"https://www.kakaocorp.com\"/>"+
		"</head>  "+
		"<body>"+
		"con%    muzI92apeach&2<a href='https://hashcode.co.kr/tos'></a>"+
		"</body>"+
		"</html>";
		String[] tmp=new String[]{"<html lang='ko' xml:lang='ko' xmlns='http://www.w3.org/1999/xhtml'> <head>"+
				  "<meta charset='utf-8'>"+
					 "<meta property='og:url' content=\"https://careers.kakao.com/interview/list\"/>"+
					"</head>  "+
					"<body>"+
					"Muzi<a href=\"https://programmers.co.kr/learn/courses/4673\">muZi</a> Muzi #!MuziMuzi!)jayg07con&&"+
					"</body>"+
					"</html>"
					,"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">"+
					"<head>"+
					  "<meta charset=\"utf-8\">"+
					  "<meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>"+
					"</head> " +
					"<body>"+
					"con%    muzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>"+

					    "^"+
					"</body>"+
					"</html>"};
					
					
					
					/*"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">"+
		"<head>"+
		  "<meta charset=\"utf-8\">"+
		  "<meta property=\"og:url\" content=\"https://b.com\"/>"+
		"</head>  "+
		"<body>"+
		"Suspendisse potenti. Vivamus venenatis tellus non turpis bibendum, "+
		"<a href=\"https://a.com\"> Link to a </a>"+
		"blind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut."+
		"<a href=\"https://c.com\"> Link to c </a>"+
		"</body>"+
		"</html>"}*/
		System.out.println(solution("Muzi",tmp));
	

	}

}
