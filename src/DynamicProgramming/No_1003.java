package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1003 {
    private static Integer[][] dp = new Integer[41][2];

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        final List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < testCaseCount; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solve(numbers);
        System.out.println(result);
    }

    private static String solve(final List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Integer number : numbers) {
            dp[number] = fibonacci(number);

            stringBuilder.append(dp[number][0])
                    .append(SPACE)
                    .append(dp[number][1])
                    .append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static Integer[] fibonacci(final int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }
}
