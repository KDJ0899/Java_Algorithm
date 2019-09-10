package OurAlgorism_January;

/**
 * 1~100까지 소수찾기
 * 
 * @Package : OurAlgorism_January
 * @FileName : primeNumber.java
 * @Author : KIM DONGJIN
 * @date : 2018. 1. 22. 
 *
 */
public class primeNumber {
	public static void main(String[] args) {
		for(int i=2;i<=100;i++) {
			int sw=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					if(j==i||j==1) 
						continue;
					else {
						sw=1;
						break;
					}
				}
			}
			if(sw==0)
				System.out.println(i);
		}
	}

}
