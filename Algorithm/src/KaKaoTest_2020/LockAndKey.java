package KaKaoTest_2020;

import java.util.Arrays;
import java.util.HashSet;

/**
  * @FileName : LockAndKey.java
  * @Project : Algorithm
  * @Date : 2019. 11. 20.
  * @Author : Kim DongJin
  * @Comment :2020카카오 자물쇠와 열쇠 문제 풀이 (진행중) 
 */
public class LockAndKey {
	
	static boolean finish = false;
	static int[][] lock;
	static int lockLength;
	static int keyLength;
	static int maxX,minX,minY,maxY;
	static HashSet<String> checked;
	
	public static boolean solution(int[][] key, int[][] lock) {
	     
		lockLength = lock.length;
		keyLength = key.length;
		
		maxX=0;
		minX=lockLength-1;
		minY=0;
		maxY=lockLength-1;
		
		checked = new HashSet<String>();
	    
		for(int i=0; i<lockLength;i ++) {
			for (int j=0; j<lockLength; j++) {
				if(lock[i][j]==0) {
					maxX=Math.max(j, maxX);
					minX=Math.min(j, minX);
					maxY=Math.max(j, maxY);
					minY=Math.min(j, minY);
				}
			}
		}
		
		
		search(key,1,0,lock);
		
	    return finish;
	}
	 
	public static void search(int[][] key, int x, int y,int[][] lock){
		 
		if(finish||checked.contains(x+" "+y)||y>maxY||x>maxX||y+keyLength<=minY||x+keyLength<=minX)
			return;
		
		for(int i= 0; i<keyLength&&y+i<lockLength; i++) {
			if(y+i>=0) {
				for(int j=0; j<keyLength && x+j<lockLength; j++) {
					if(x+j>=0) {
						lock[y+i][x+j]+=key[i][j]; 
//						lock[x+j][keyLength-1-y-i]+=key[i][j];
//						lock[keyLength-1-x-j][keyLength-1-y-i]+=key[i][j];
//						lock[keyLength-1-y-i][x+j]+=key[i][j];
					}
						
				}
			}
		}
		for(int i=0; i<lockLength; i++)
			System.out.println(Arrays.toString(lock[i]));
		
	}
	
	public static int[][] rotate(int[][] key, int x, int y,int[][] lock) {
		
		int[][] newArr = new int[keyLength][keyLength];
		for(int i=0; i<keyLength; i++) {
			for(int j=0; j<keyLength; j++) {
				newArr[j][keyLength-1-i] = key[i][j];
			}
		}
		
		return newArr;
		
	}


	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{0,0,0},{1,0,0},{0,1,1}} , new int[][] {{1,1,1},{1,1,0},{1,0,1}} ));

	}

}
