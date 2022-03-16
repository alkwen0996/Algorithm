package BaekJoon.Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_3034 {
	private static final String CAN = "DA"; 
	private static final String CANNOT = "NE";
	private static final String SPACE = " ";
	private static final String NEXT_LINE = "\n";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int slash = (int)Math.sqrt(((int)(Math.pow(W, 2)) + (int)(Math.pow(H, 2))));
		
		StringBuilder sb = new StringBuilder();// ���
		for(int i = 0; i < N; i++){
//			if(Integer.parseInt(br.readLine()) > slash){
//				sb.append(CANNOT).append(NEXT_LINE);
//			}
//			else{
//				sb.append(CAN).append(NEXT_LINE);
//			}
			sb.append(Integer.parseInt(br.readLine()) > slash ? CANNOT + NEXT_LINE : CAN + NEXT_LINE);
		}// append�� ()���� �޾Ƴ�.
		
		br.close();// �׻�������
		
		System.out.println(sb.toString());
	}
}
