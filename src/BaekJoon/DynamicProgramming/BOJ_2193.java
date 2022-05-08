package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        long[] memorization = new long[n + 1];

        System.out.println(countPinaryNumber(n, memorization));
    }

    private static long countPinaryNumber(final int n, final long[] memorization) {
        if (n <= 2) {
            return 1;
        }

        memorization[1] = memorization[2] = 1;

        for (int i = 3; i <= n; i++) {
            memorization[i] = memorization[i - 1] + memorization[i - 2];
        }

        return memorization[n];
    }
}
