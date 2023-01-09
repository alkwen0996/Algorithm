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

        final int period = Integer.parseInt(stringTokenizer.nextToken());
        final int chapterCount = Integer.parseInt(stringTokenizer.nextToken());

        final int[][] data = new int[chapterCount + 1][2];
        final int[][] dp = new int[chapterCount + 1][period + 1];

        for (int i = 1; i <= chapterCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int days = Integer.parseInt(stringTokenizer.nextToken());
            final int pages = Integer.parseInt(stringTokenizer.nextToken());

            data[i][0] = days;
            data[i][1] = pages;
        }

        System.out.println(findMaximumValue(data, dp));
    }

    private static int findMaximumValue(final int[][] data, final int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
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

