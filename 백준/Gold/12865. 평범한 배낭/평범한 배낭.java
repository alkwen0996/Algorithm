import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int totalCount = Integer.parseInt(stringTokenizer.nextToken());
        final int totalWeight = Integer.parseInt(stringTokenizer.nextToken());

        final int[][] data = new int[totalCount + 1][2];
        final int[][] dp = new int[totalCount + 1][totalWeight + 1];

        for (int i = 1; i <= totalCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int weight = Integer.parseInt(stringTokenizer.nextToken());
            final int value = Integer.parseInt(stringTokenizer.nextToken());

            data[i][0] = weight;
            data[i][1] = value;
        }

        System.out.println(findMaximumValue(totalCount, totalWeight, data, dp));
    }

    private static int findMaximumValue(final int totalCount, final int totalWeight, final int[][] data, final int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (data[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - data[i][0]] + data[i][1]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}

