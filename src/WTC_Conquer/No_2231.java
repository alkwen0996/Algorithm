package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2231 {
    public static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        solve(N);
    }

    private static void solve(final int n) {
        int result = 0;

        for (int i = 1; i <= MAX; i++) {
            int constructor = 0;
            char[] number = String.valueOf(i).toCharArray();

            for (final char c : number) {
                constructor += Integer.parseInt(String.valueOf(c));
            }

            constructor += i;

            if (constructor == n) {
                result = i;
                break;
            }
        }

        if (result == MAX) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}
