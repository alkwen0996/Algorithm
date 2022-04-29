package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    private static final String NEW_LINE = "\n";
    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        memorization = new int[11];
        memorization[1] = 1;
        memorization[2] = 2;
        memorization[3] = 4;

        for (int i = 4; i < 11; i++) {
            memorization[i] = memorization[i - 1] + memorization[i - 2] + memorization[i - 3];
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            stringBuilder.append(memorization[Integer.parseInt(bufferedReader.readLine())]).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

}
