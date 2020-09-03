package kakao_internship_2020;

import java.util.Arrays;
/**
 * 
  * @FileName : Programming4.java
  * @Project : Algorithm
  * @Date : 2020. 5. 23. 
  * @Author : Kim DongJin
  * @Comment : 도로를 짓는데 최소 비용, 직진 100, 커브 600
 */
public class Programming4 {
	
	public static int solution(int[][] board) {
        int answer = 0;
        
        int[][] prices = new int[board.length][board[0].length];
        
        build(0, 0, prices, board, Direction.DOWN, 0);
        build(0, 0, prices, board, Direction.RIGHT, 0);
        
        answer = prices[board.length-1][board[0].length-1];
        
        for(int i=0; i<prices.length; i++) {
        	System.out.println(Arrays.toString(prices[i]));
        }
        
        return answer;
    }
	
	public static void build(int x, int y, int[][] prices, int[][] board,Direction direction, int price) {
		
		if(prices[x][y] >0 && prices[x][y] < price)
			return;
		
		prices[x][y] = price;
		
		for(Direction dir : Direction.values()) {
			dir.move(x, y, prices, board, direction, price);
		}
	}
	
	enum Direction{
		UP {
			@Override
			void move(int x, int y, int[][] prices, int[][] board, Direction direction,int price) {
				if(y-1<0 || direction == DOWN || board[x][y-1] == 1)
					return;
				
				if(direction == this)
					price+=100;
				else
					price+=600;
				
				build(x, y-1, prices, board, UP, price);
			}
		},
		DOWN {
			@Override
			void move(int x, int y, int[][] prices, int[][] board, Direction direction, int price) {
				if(y+1>=prices.length || direction == UP || board[x][y+1] == 1)
					return;
				
				if(direction == this)
					price+=100;
				else
					price+=600;
				
				build(x, y+1, prices, board, DOWN, price);
			}
		},
		LEFT {
			@Override
			void move(int x, int y, int[][] prices, int[][] board, Direction direction, int price) {
				if(x-1<0 || direction == RIGHT || board[x-1][y] == 1)
					return;
				
				if(direction == this)
					price+=100;
				else
					price+=600;
				
				build(x-1, y, prices, board, LEFT, price);
			}
		},
		RIGHT{
			@Override
			void move(int x, int y, int[][] prices, int[][] board, Direction direction, int price) {
				if(x+1>=prices[0].length|| direction == LEFT || board[x+1][y] == 1)
					return;
				
				if(direction == this)
					price+=100;
				else
					price+=600;
				
				build(x+1, y, prices, board, RIGHT, price);
				
			}
		};
		
		abstract void move(int x, int y,int[][] prices, int[][] board,Direction direction, int price);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,0,0},{0,0,0},{0,0,0} }));
		System.out.println(solution(new int[][] {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0} }));
	}

}
