package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 
  * @FileName : PhoneNumberList.java
  * @Project : Algorithm
  * @Date : 2020. 1. 10. 
  * @Author : Kim DongJin
  * @Comment : 프로그래머스 해시 전화번호 목록 문제 풀이
 */
public class PhoneNumberList {
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<Integer> numLengthList = new HashSet<Integer>();
        HashSet<String> numberList = new HashSet<String>();
        
        for(int i=0; i<phone_book.length; i++) {
        	numLengthList.add(phone_book[i].length());
            numberList.add(phone_book[i]);
        }
        
        for(int i=0; i<phone_book.length; i++) {

            for(int length : numLengthList) {
                if(length<phone_book[i].length()) {
                    if(numberList.contains(phone_book[i].substring(0, length)))
                        return false;
                }
            }
        }
        
        return answer;
    }
	
	

	public static void main(String[] args) {
		System.out.println();
	}

}
