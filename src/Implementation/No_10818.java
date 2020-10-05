package Implementation;

import java.util.Scanner;

public class No_10818 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int numCnt = sc.nextInt();
		
		int [] nums = new int[numCnt];
		
		for (int i = 0; i < numCnt; i++) {
			nums[i] = sc.nextInt();
		}
		
		int max = nums[0];
		int min = nums[0];
		
		for (int i = 0; i < numCnt; i++) {
			
			if(max < nums[i]) 
				max = nums[i];
			
			if(min > nums[i]) 
				min = nums[i];
		}// for
		
		System.out.println(min+" "+max);
		
	}// main
}// class
