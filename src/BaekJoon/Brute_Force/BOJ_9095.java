package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            stringBuilder.append(solution(bufferedReader.readLine())).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solution(final String readLine) {
        final int testCase = Integer.parseInt(readLine);

        int[] combinationCount = new int[12];

        combinationCount[1] = 1;
        combinationCount[2] = 2;
        combinationCount[3] = 4;

        for (int i = 4; i < combinationCount.length; i++) {
            combinationCount[i] = combinationCount[i - 1] + combinationCount[i - 2] + combinationCount[i - 3];
        }

        return combinationCount[testCase];
    }
}
