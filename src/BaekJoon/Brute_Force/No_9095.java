package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_9095 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> testCase = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            testCase.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solution(testCase);
        System.out.println(result);
    }

    private static String solution(final List<Integer> testCase) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : testCase) {
            stringBuilder.append(countMakeNumberCase(integer)).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static int countMakeNumberCase(final Integer integer) {
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= integer; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[integer];
    }
}
