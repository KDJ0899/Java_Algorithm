package kakao_internship_2020;
/**
 * 
  * @FileName : Programming1.java
  * @Project : Algorithm
  * @Date : 2020. 5. 23. 
  * @Author : Kim DongJin
  * @Comment : 휴대폰 키패드 문제, 
 */
public class Programming1 {
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int num, leftX = 0, leftY = 3, rightX = 2, rightY = 3, lengthL, lengthR, y; 
        boolean right;
        
        for(int i=0; i<numbers.length; i++) {
        	num = numbers[i];
        	lengthL = 0;
        	lengthR = 0;
        	
        	if(num % 3 ==1) {
        		answer+="L";
        		leftX = 0;
        		leftY = num/3;
        	}
        	else if (num == 0 || num % 3 ==2) {
        		System.out.println(rightX+" "+rightY);
        		if(num == 0) {
        			lengthL += 1 - leftX + 3 - leftY;
        			lengthR += rightX - 1 + 3 - rightY; 
        			y = 3;
        		}
        		else {
        			lengthL += 1 - leftX +  Math.abs(num/3 - leftY);
        			lengthR += rightX - 1  + Math.abs(num/3 - rightY);
        			y = num/3;
        		}
        		if(lengthL<lengthR)
        			right = false;
        		else if(lengthL>lengthR)
        			right = true;
        		else if(hand.equals("right"))
        			right = true;
        		else
        			right = false;
        		
        		
        		if(right) {
        			answer+="R";
        			rightX = 1;
        			rightY = y;
        		}
        		else {
        			answer+="L";
        			leftX = 1;
        			leftY = y;
        		}
        	}
        	
        	else {
        		answer+="R";
        		rightX = 2;
        		rightY = num/3-1;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
	}

}
