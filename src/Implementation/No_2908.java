package Implementation;

import java.util.Scanner;

public class No_2908 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String fir = sc.next();
		String sec = sc.next();
		
		String reverseFir = "";
		String reverseSec = "";
		
		for (int i = fir.length()-1; i >=0 ; i--) {
			
			reverseFir += fir.charAt(i);
			reverseSec += sec.charAt(i);
		}
		
		int numFir = Integer.parseInt(reverseFir);
		int numSec = Integer.parseInt(reverseSec);
		
		if(numFir > numSec) {
			System.out.println(numFir);
		}else {
			System.out.println(numSec);
		}
		
	}
}
