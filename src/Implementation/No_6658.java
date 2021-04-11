package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_6658 {
    // 1. 해당 수의 소수를 모두 구한다.
    // 2. 소수 중 두 수의 합으로 입력받은 수를 만들 수 있는 경우를 구한다.
    // 3. 여러 조합이면 b-a가 가장 큰 것으로 추출한다.
    static final int MAX = 1000000;
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Boolean [] arr = new Boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++)
            arr[i] = true;

        for (int i = 2; i <= MAX; i++) {
            for (int j = i + i; j <= MAX; j += i) {
                if(!arr[j]) continue;
                arr[j] = false;
            }//for_j
        }//for_i

        while (true) {
            int num = Integer.parseInt(br.readLine());
            boolean ok = false;
            if (num == 0)
                break;

            for (int i = 2; i <= num/2; i++) {
                if (arr[i] && arr[num-i] ){
                    System.out.println(num+" = "+i+" + "+(num-i));
                    ok = true;
                    break;
                }
            }//for_i

            if(!ok)
                System.out.println("Goldbach's conjecture is wrong.");

        }// while
        br.close();

    }// main
}// class
