package MCC_180201;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateExample1 {
	public static void main(String[] args)throws Exception{
		String sDate1="01/02/2018";
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		System.out.println(sDate1+"\t"+date1);
		}
}
