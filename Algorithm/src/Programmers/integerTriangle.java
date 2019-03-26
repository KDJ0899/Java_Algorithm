package Programmers;

/**
 * 
  * @FileName : integerTriangle.java
  * @Project : Algorithm
  * @Date : 2019. 3. 25. 
  * @Author : Kim DongJin
  * @Comment :
 */

public class integerTriangle {
	 static int n, m;
	 static int data[][];
	 static int numbers[][];

    public static int solution(int[][] triangle) {
        n = triangle.length;
        m = triangle[n-1].length;
        data = new int[n][m];
        numbers = triangle;
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                data[i][j] = -1;
            }
        }
        return maxLR(0, 0);
    }

    public static int maxLR(int n, int i) {
        if(n == m-1) {return numbers[n][i];}
        else if(data[n][i] != -1) {return data[n][i];}
        else {
            return data[n][i] = numbers[n][i] + Math.max(maxLR(n+1, i), maxLR(n+1, i+1));
        }
    }
	
	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

}

