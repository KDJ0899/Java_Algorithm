package MCC_180313;

import java.util.Scanner;

public class assign {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Number of users:");
		int n=sc.nextInt();
		int[] user=new int[n];
		int[] timeH=new int[n];
		int[] timeM=new int[n];
		int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
		int loginM = 0,loginH = 0,loginD = 0,loginMon = 0;
		int logoutM=0,logoutH=0,logoutD=0,logoutMon=0;
		int max=0;
		String str="";
		char[] word;
		boolean change=false;
		String[] loginTime=new String[n];
		String[] loginDate=new String[n];
		String[] logoutTime=new String[n];
		String[] logoutDate=new String[n];
		System.out.println("USER                 LOGIN          LOGOUT");
		System.out.println("IDENTIFICATION       TIME&DATE      TIME&DATE");
		
		for(int i=0;i<n;i++) {
			user[i]=sc.nextInt();
			loginTime[i]=sc.next();
			loginDate[i]=sc.next();
			logoutTime[i]=sc.next();
			logoutDate[i]=sc.next();			
		}
		System.out.println("USER                 LOGIN          LOGOUT     DURATION");
		System.out.println("IDENTIFICATION       TIME&DATE      TIME&DATE  HOURS MIN");
		for(int i=0;i<n;i++) {
			word=loginTime[i].toCharArray();
			str="";
			for(int j=0;j<word.length;j++) {
				if(word[j]==':') {
					loginH=Integer.parseInt(str);
					str="";
					continue;
				}
				str+=word[j];
			}
			loginM=Integer.parseInt(str);
			
			word=loginDate[i].toCharArray();
			str="";
			for(int j=0;j<word.length;j++) {
				if(word[j]=='-') {
					loginD=Integer.parseInt(str);
					str="";
					continue;
				}
				str+=word[j];
			}
			loginMon=Integer.parseInt(str);
		
			word=logoutTime[i].toCharArray();
			str="";
			for(int j=0;j<word.length;j++) {
				if(word[j]==':') {
					logoutH=Integer.parseInt(str);
					str="";
					continue;
				}
				str+=word[j];
			}
			logoutM=Integer.parseInt(str);
			
			word=logoutDate[i].toCharArray();
			str="";
			for(int j=0;j<word.length;j++) {
				if(word[j]=='-') {
					logoutD=Integer.parseInt(str);
					str="";
					continue;
				}
				str+=word[j];
			}
			logoutMon=Integer.parseInt(str);
			timeH[i]=0;
			timeM[i]=0;
			if(loginMon==logoutMon) {
				timeH[i]+=24*(logoutD-loginD);
				timeH[i]+=logoutH-loginH;
				if(loginM>logoutM) {
					timeH[i]--;
					timeM[i]+=60+logoutM-loginM;
				}
				else
					timeM[i]+=logoutM-loginM;
			}
			else {
				timeH[i]+=24*(days[i]-loginD);
				timeH[i]+=24*(logoutD);
				timeH[i]+=logoutH-loginH;
				if(loginM>logoutM) {
					timeH[i]--;
					timeM[i]+=60+logoutM-loginM;
				}
				else
					timeM[i]+=logoutM-loginM;
			}
			if(timeH[i]>timeH[max])
				max=i;
			else if(timeH[i]==timeH[max]) {
				if(timeM[i]>timeM[max])
					max=i;
			}		
			System.out.print(user[i]+"                  ");	
			System.out.print(loginH+":"+loginM+" ");
			System.out.print(loginD+"-"+loginMon+"    ");
			System.out.print(logoutH+":"+logoutM+" ");
			System.out.print(logoutD+"-"+logoutMon+"   ");
			System.out.println(timeH[i]+":"+timeM[i]);
		}
		System.out.println("The user who logged in for the longest duration");
		System.out.println(user[max]+"                  "+loginTime[max]+" "+loginDate[max]+"    "+logoutTime[max]+" "+logoutDate[max]+"   "+timeH[max]+":"+timeM[max]);
	}
}
