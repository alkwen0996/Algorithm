package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        int result = solution(N);
        System.out.println(result);
    }

    private static int solution(final int n) {
        int length = 0;
        int increase = 1;
        int unit = 10;

        for (int i = 1; i <= n; i++) {
            if (i % unit == 0) {
                unit *= 10;
                increase++;
            }
            length += increase;
        }

        return length;
    }
}
