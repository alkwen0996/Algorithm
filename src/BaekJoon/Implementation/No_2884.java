package BaekJoon.Implementation;

import java.io.IOException;
import java.util.Scanner;

// 맞춤
public class No_2884 {
	public static void main(String args[])throws IOException {
		
		
		 Scanner sc = new Scanner(System.in); 
		 int input_hour = sc.nextInt(); 
		 int input_min =sc.nextInt();
		 
		 alarm(input_hour,input_min);
		
	}// main

	private static void alarm(int input_hour, int input_min) {
		
		int s_min = input_min-45;
		
		if(s_min<0) {
			input_hour = input_hour-1;
			if(input_hour<0) {
				input_hour= 23;
			}
			s_min = input_min+60-45;
		}
		
		System.out.println(input_hour+" "+s_min);
			
		
	}// alarm
}// class
