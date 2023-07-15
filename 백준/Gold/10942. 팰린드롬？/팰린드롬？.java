import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(check(start,end)+"\n");
		}
		System.out.println(sb);
	}
	static int check(int start,int end) {
		int mid = (end-start)/2;
		for(int i=0;i<=mid;i++) {
			if(arr[start+i]!=arr[end-i]) return 0;
		}
		return 1;
	}

}
