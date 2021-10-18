package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 이산수학과제
public class NO_14723 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        solve(N);
    }

    private static void solve(final int n) {
        int a = 0;
        int b = 0;
        int index = 0;

        while (index != n) {
            if (a == 0 && b == 0) {
                a++;
                b++;
            } else {
                if (a == 1 && b == 1) {
                    a++;
                } else if (a == 1 && b > 1) {
                    a = b + 1;
                    b = 1;
                } else {
                    a--;
                    b++;
                }
            }
            index++;
        }

        System.out.println(a + " " + b);
    }
}
