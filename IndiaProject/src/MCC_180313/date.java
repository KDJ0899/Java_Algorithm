package MCC_180313;

import java.util.Scanner;

public class date {

	public static void main(String[] args) {
		int day,month,year,sum=0,dayMax=28,upMon,downMon;
		System.out.println("Enter your date of birth in dd mm yyyy format");
		Scanner sc=new Scanner(System.in);
		day=sc.nextInt();
		month=sc.nextInt();
		year=sc.nextInt();
		int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
		if(month<1||month>12) {
			System.out.println("INVALID NUMBER");
			return;
		}
		if(year%4==0)
			days[1]=29;
		if(day>days[month-1]){
			System.out.println("INVALID NUMBER");
			return;
		}
		System.out.println("VALID NUMBER");
		for(int i=0;i<month-1;i++) {
			sum+=days[i];
		}
		sum+=day;
		System.out.println(sum);
		
	}

}
