package BaekJoon.Implementation;

import java.io.IOException;
import java.util.Scanner;

public class No_1022 {
	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int r1 = sc.nextInt(); //위
		int c1 = sc.nextInt(); // 왼쪽
		int r2 = sc.nextInt(); // 아래
		int c2 = sc.nextInt(); // 오른쪽
		
		createHurricane(r1,r2,c1,c2);

	} // main

	private static void createHurricane(int r1, int r2, int c1, int c2) {
		
	int rLength = r2-r1+1;
	int cLength = c2-c1+1;
	//System.out.println(rLength+"/"+cLength);
	
	int lastNum = rLength * cLength;
	int gab = rLength + cLength-2;
	int firstNum = lastNum-gab;
	
	for (int i = 0; i < rLength; i++) {
		System.out.print(firstNum-i+" ");
	}
	
		
	} // createHurricane
}// class
