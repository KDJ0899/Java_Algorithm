package kaKaoTest_2020;

/**
  * @FileName : ConvertParentheses.java
  * @Project : Algorithm
  * @Date : 2019. 11. 19.
  * @Author : Kim DongJin
  * @Comment :2020카카오 괄호 변환 문제 풀이 (완료)
 */
public class ConvertParentheses {


	public static String solution(String p) { 
        String u =p,v="";
        
        if(p.equals("")) // 현재 단어가 없으면 빈칸으로 반환.
        	return "";
        
        int postCount=0,preCount=0;
        boolean correct = true;
        char[] ch = p.toCharArray();
        
        for(int i=0; i<ch.length; i++) { //앞부분 u가 알맞은 괄호 인지 확인하고 u와 v를 나누는 과정.
        	if(ch[i]=='(') {
        		preCount++;
        	}
        	else {
        		postCount++;
        	}
        	if(postCount>preCount) {
        		correct = false;
        	}
        	if(postCount==preCount) {
        		u = p.substring(0, i+1);
        		v = p.substring(i+1);
        		break;
        	}
        }
        
        if(!correct) { //u가 알맞은 괄호가 아닐시, 규칙에 따라 맞는 괄호로 변환 하는 과정.
        	String str="(";
        	str+=solution(v)+")";
        	
        	u=u.substring(1,u.length()-1);
        	ch = u.toCharArray();
        	
        	for(int i=0; i<ch.length; i++) {
        		if(ch[i]=='(')str+=")";
        		else str+="(";
        	}
        		
        	return str;
        }
        
        return u+solution(v);
    }
	
	
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));

	}

}
