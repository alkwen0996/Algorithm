package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
    private static final int MOD = 1_000_000_009;
    private static final int MAXIMUM_RANGE = 100_000;
    private static final int NUMBER_OF_AVAILABLE_NUMBERS = 4;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseNumber = Integer.parseInt(bufferedReader.readLine());

        int[] numberToCreate = new int[testCaseNumber];
        long[][] memorization = new long[MAXIMUM_RANGE + 1][NUMBER_OF_AVAILABLE_NUMBERS];

        for (int i = 0; i < testCaseNumber; i++) {
            numberToCreate[i] = Integer.parseInt(bufferedReader.readLine());
        }

        memorization[1][1] = 1;
        memorization[1][2] = 0;
        memorization[1][3] = 0;

        memorization[2][1] = 0;
        memorization[2][2] = 1;
        memorization[2][3] = 0;

        memorization[3][1] = 1;
        memorization[3][2] = 1;
        memorization[3][3] = 1;

        System.out.println(numberOfWaysToCreate(numberToCreate, memorization));
    }

    private static StringBuilder numberOfWaysToCreate(final int[] numberToCreate, final long[][] memorization) {
        for (int i = 4; i <= MAXIMUM_RANGE; i++) {
            memorization[i][1] = (memorization[i - 1][2] + memorization[i - 1][3]) % MOD;
            memorization[i][2] = (memorization[i - 2][1] + memorization[i - 2][3]) % MOD;
            memorization[i][3] = (memorization[i - 3][1] + memorization[i - 3][2]) % MOD;
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (final int j : numberToCreate) {
            stringBuilder.append((memorization[j][1] + memorization[j][2] + memorization[j][3]) % MOD).append(NEW_LINE);
        }

        return stringBuilder;
    }
}
