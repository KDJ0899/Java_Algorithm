package OurAlgorism_October;

public class a_la_russe {
/**
 * a la russe(러시아 농부 곱셈법)
 * 
 * 코드의 수행시간을 측정할떄는 System.nanoTime()을 쓰는게 좋음
 * 
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
