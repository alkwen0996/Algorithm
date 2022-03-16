package BaekJoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 1;
        for (int i = 0; i < 3; i++) {
            sum = sum * Integer.parseInt(bufferedReader.readLine());
        }

        char[] sumChars = String.valueOf(sum).toCharArray();
        int[] results = new int[10];

        // sumchars[i] = '0'~'9'
        // '0' = 아스키코드로 숫자 ex) 100 가정
        // '0' - '0' = 0
        // '1' - '0' = 1
        // case 'x': results[x]++; break;

        for (char sumChar : sumChars) {
            results[sumChar - '0']++;
        }

        for (int result : results) {
            System.out.println(result);
        }
    }
}
