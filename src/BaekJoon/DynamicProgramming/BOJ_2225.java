package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        long[][] memorization = new long[k + 1][n + 1];
        long result = countNumberOfCase(memorization, n, k);

        System.out.println(result);
    }

    private static long countNumberOfCase(final long[][] memorization, final int n, final int k) {
        memorization[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    memorization[i][j] += memorization[i - 1][j - l];
                    memorization[i][j] %= MOD;
                }
            }
        }

        return memorization[k][n];
    }
}
