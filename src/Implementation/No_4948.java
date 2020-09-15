package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;
	    
	    while (br.lines() !=null) {
	    	int N = Integer.parseInt(br.readLine());
	    	if(N==0) {
	    		break;
	    	}
			System.out.println(isPrime(N));
		}
    }
    
    private static int isPrime(int n) {
    	int count = 0;
    	
    	boolean chkPrime [] = new boolean[2*n+1];
    	Arrays.fill(chkPrime, true);
    	
    	chkPrime[0]= false;
    	chkPrime[1]= false;
    	
    	
    	for (int i = 2; i <=n ; i++) {
    		if(!chkPrime[i]) {
    			continue;
    		}
			for (int j = i*2; j <=2*n; j+=i) {
				chkPrime[j]=false;
			}
		}
    	
    	
    	for (int i = n+1; i <=2*n; i++) {
			if(chkPrime[i]) {
				System.out.println(i);
				count++;
			}
		}
            return count;
    }
}

/**
 * @author 이민수
 * @date2019. 4. 19.time오전 8:34:36
 * @subject
 * 
1
10
13
100
1000
10000
100000
0

1
4
3
21
135
1033
8392
 */
