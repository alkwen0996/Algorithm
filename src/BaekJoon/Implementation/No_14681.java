package BaekJoon.Implementation;

import java.util.Scanner;

public class No_14681 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.nextLine());
		int y = Integer.parseInt(sc.nextLine());
		
		int result = quadrant(x,y);
		System.out.println(result);
	}

	private static int quadrant(int x, int y) {
		
		int result = 0;
		
		if(x>0 && y>0) {
			result =1;
		}else if(x<0 && y>0) {
			result = 2;
		}else if(x<0 && y<0) {
			result = 3;
		}else if(x>0 && y<0) {
			result = 4;
		}
		
		return result;
	}
}
