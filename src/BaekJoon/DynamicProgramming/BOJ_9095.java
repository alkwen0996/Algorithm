package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9095 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> testCases = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            testCases.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solution(testCases);
        System.out.println(result);
    }

    private static String solution(final List<Integer> testCases) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Integer testCase : testCases) {
            stringBuilder.append(getSumCount(testCase)).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static int getSumCount(final Integer integer) {
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[integer];
    }
}
