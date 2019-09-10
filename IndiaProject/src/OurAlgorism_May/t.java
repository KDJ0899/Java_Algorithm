package OurAlgorism_May;

import java.util.Arrays;
import java.util.HashMap;

public class t {
	public static void tt(int[] arr) {
		int [] newArr=new int[arr.length];
		for(int i=0; i<arr.length;i++)
			newArr[i]=arr[i];
		for(int i=0; i<arr.length;i++) {
			if(newArr[i]==1)
				continue;
			newArr[i]=1;
			tt(newArr);
		}
	}
	public static void main(String[] args) {
		String[] arr= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] a=arr[0].split(" ");
		HashMap map=new HashMap<>();
		map.put(a[1], a[2]);
		System.out.println(map.get(a[1]));
		
	}

}
