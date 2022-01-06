package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1463 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());

        dp = new int[x + 1];
        dp[0] = dp[1] = 0;

        int result = recursive(x);
        System.out.println(result);
    }

    private static int recursive(int x) {
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

        }

        return dp[x];
    }
}
