package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
  * @FileName : ComplexNumbering.java
  * @Project : Algorithm
  * @Date : 2020. 10. 15. 
  * @Author : Kim DongJin
  * @Comment :백준 2667 단지 번호 붙이기 문제 풀이 완료.
 */

public class ComplexNumbering {

    static int n;
    static int[][] complex ;
    static Queue<House> nextHouse;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        n = sc.nextInt();
        complex = new int[n][n];
        nextHouse = new LinkedList<House>();
        List<Integer> answers = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++){
            String str = sc.next();
            char[] nums = str.toCharArray();
            for(int j=0; j<nums.length; j++){
                complex[i][j] = Integer.parseInt(nums[j]+"");
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(complex[i][j] == 1){
                    count = 0;
                    nextHouse.offer(new House(i, j));

                    while(!nextHouse.isEmpty()){
                        House house = nextHouse.poll();
                        if(complex[house.i][house.j] == 1){
                            complex[house.i][house.j] = 0;
                            count++;
                            house.move();
                        }
                    }
                    answers.add(count);
                }
            }
        }

        answers.sort(null);

        System.out.println(answers.size());
        for(int anw : answers)
            System.out.println(anw);
        sc.close();
    }

    static class House {
        int i;
        int j;

        public House(int i, int j){
            this.i = i;
            this.j = j;
        }

        public void move(){
            if(i-1>=0 && complex[i-1][j] == 1){
                nextHouse.add(new House(i-1, j));
            }
            if(i+1<n && complex[i+1][j] == 1){
                nextHouse.add(new House(i+1, j));
            }
            if(j-1>=0 && complex[i][j-1] == 1){
                nextHouse.add(new House(i, j-1));
            }
            if(j+1<n && complex[i][j+1] == 1){
                nextHouse.add(new House(i, j+1)); 
            }
        }
    }
}
