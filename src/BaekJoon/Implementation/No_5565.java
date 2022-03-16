package BaekJoon.Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5565 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		int reSum = 0;
		
		for(int i = 0; i < 9; i++){
			reSum += Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		System.out.println(sum - reSum);
	} 
}
