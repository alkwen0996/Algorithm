package Implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//맞춤.
public class No_1764 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])throws IOException {	
		 
		 int noSee = sc.nextInt(); 
		 int noListen =sc.nextInt();
		 
		 int inputCnt = noSee+noListen;
		 
		 findCommon(inputCnt,noSee,noListen); 
		 
	}// main

	private static void findCommon(int inputCnt, int noSee, int noListen) {
	
		
		List<Object> list= new ArrayList<>();  
		  
		for (int i = 0; i < inputCnt; i++) { 
		  list.add(sc.next()); 
		} 

		list.sort(null);
		
		List<Object> res= new ArrayList<>();  
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i).equals(list.get(i+1))) {
				res.add(list.get(i));
			}// if
		}// for
		
		System.out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		 
	}//findCommon
}// class
