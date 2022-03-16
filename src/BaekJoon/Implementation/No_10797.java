package BaekJoon.Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class No_10797 {
	private static final String SPACE = " ";
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int day = Integer.parseInt(br.readLine());
		int res = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		for(int i = 0; i < 5; i++){
			int car = Integer.parseInt(st.nextToken());
			
			if(day == car){
				res++;
			}
		}
		System.out.println(res);
	}
}
