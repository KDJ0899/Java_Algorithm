package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
  * @FileName : expressAsN.java
  * @Project : Algorithm
  * @Date : 2019. 3. 13. 
  * @Author : Kim DongJin
  * @Comment :프로그래머스 동적 계획법 - N으로 표현 문제 (완로)
 */
public class expressAsN {
	
	static int minCount=9,n, goalNum;

	public static int solution(int N, int number) {
        goalNum=number;
        n=N;
        recursion(0,0,"");
        
        return (minCount==9)? -1 : minCount;
    }
	
	public static void recursion(int nowVal, int count,String str) {
		int nowNum=0;
		
		if(nowVal==goalNum) {
			minCount=Math.min(count, minCount);
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(count>=minCount) 
				return;
			nowNum=Integer.parseInt(nowNum+""+n);
			count++;
			recursion(nowVal+nowNum,count,str+"+"+nowNum);
			recursion(nowVal-nowNum,count,str+"-"+nowNum);
			recursion(nowVal*nowNum,count,str+"*"+nowNum);
			recursion(nowVal/nowNum,count,str+"/"+nowNum);

		}
		
		
	}
	
	
	public static int solutionModel(int N, int number) {
        int answer = -1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();
        s.add(N);
        map.put(1, s);

        loop : for (int i = 2; i < 9; i++) {
            HashSet<Integer> set = new LinkedHashSet<>();

            int NNN = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;
            
            if (NNN == number){
                return i;
            }

            set.add(NNN);
            
            for (int j = 1; j <= i / 2; j++) {
                Iterator<Integer> it1 = map.get(j).iterator();
                Iterator<Integer> it2 = map.get(i - j).iterator();

                while (it1.hasNext()) {
                    int itValue1 = it1.next();
                    while (it2.hasNext()) {
                        int itValue2 = it2.next();
                        for (Operator o : Operator.values()) {
                            int calculate = o.calculate(itValue1, itValue2);
                            if (calculate == number){
                                answer = i;
                                break loop;
                            }

                            set.add(calculate);
                        }
                    }
                }
            }
            map.put(i, set);
        }

        return answer;
    }

    enum Operator {
        PLUS {
            @Override
            public int calculate(int i, int j) {
                return i + j;
            }
        }, MINUS {
            @Override
            public int calculate(int i, int j) {
                return i - j;
            }
        }, BACKMINUS {
            @Override
            public int calculate(int i, int j) {
                return j - i;
            }
        }, MUL {
            @Override
            public int calculate(int i, int j) {
                return i * j;
            }
        }, DIV {
            @Override
            public int calculate(int i, int j) {
                if (j == 0){
                    return 0;
                }
                return i / j;
            }
        }, BACKDIV {
            @Override
            public int calculate(int i, int j) {
                if (i == 0){
                    return 0;
                }
                return j / i;
            }
        };

        public abstract int calculate(int i, int j);
    }

	
	public static void main(String[] args) {
		
		System.out.println(solutionModel(5, 12));
	}

}
