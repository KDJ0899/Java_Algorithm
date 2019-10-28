package OurAlgorism_October;

public class a_la_russe {
/**
 * a la russe 알고리즘(곱하기 알고리즘)
 * 
 * 곱하기 기호를 사용하지 않고 곱셈을 하는 방법이 궁금해져서 찾아봄
 * for문을 사용해서 일일이 더하는 것보다 훨씬 빠른 방법
 *
 * @Method Name : main
 * @param args
 */

	public static void main(String[] args) {
		long start=System.nanoTime();
		int val1=123124123, val2=22242323, sum=0;
		
		while(val1>1) {
			
			if((val1&1)==1) {
				sum+=val2;
			}
			val1 >>= 1;
			val2 <<= 1;
		}
		sum+=val2;
		
		long end = System.nanoTime();
		System.out.println((end-start)/1000.0+" "+ sum);
		
		start=System.nanoTime();
		
		val1=123124123;
		val2=22242323;
		sum=0;
		for(int i=0;  i<val2; i++) {
			sum+=val1;
		}
		end = System.nanoTime();
		System.out.println((end-start)/1000.0+" "+ sum);
		
		
		start=System.nanoTime();
		
		val1=123124123;
		val2=22242323;
		
		sum=val1*val2;
		end = System.nanoTime();
		System.out.println((end-start)/1000.0+" "+ sum);
		
		

	}

}
