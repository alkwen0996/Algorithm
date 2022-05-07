package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int lengthOfNumber = Integer.parseInt(bufferedReader.readLine());

        long[][] memorization = new long[lengthOfNumber + 1][10];

        for (int i = 1; i <= 9; i++) {
            memorization[1][i] = 1;
        }

        System.out.println(countStairNumber(lengthOfNumber, memorization));
    }

    private static long countStairNumber(final int lengthOfNumber, final long[][] memorization) {
        for (int i = 2; i <= lengthOfNumber; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    memorization[i][j] += memorization[i - 1][j - 1];
                }

                if (j + 1 <= 9) {
                    memorization[i][j] += memorization[i - 1][j + 1];
                }

                memorization[i][j] %= MOD;
            }
        }

        long stairNumberCount = 0;

        for (int i = 0; i <= 9; i++) {
            stairNumberCount += memorization[lengthOfNumber][i];
        }

        return stairNumberCount % MOD;
    }
}
