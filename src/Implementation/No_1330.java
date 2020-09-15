package Implementation;

import java.util.Scanner;

public class No_1330 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String result = compareTo(a,b);
		System.out.println(result);

	} // main

	private static String compareTo(int a, int b) {
		
		String result = "";
		
		if(a>b) {
			result = ">";
		}else if (a<b) {
			result = "<";
		}else {
			result = "==";
		}
		return result;
	}
} // class
