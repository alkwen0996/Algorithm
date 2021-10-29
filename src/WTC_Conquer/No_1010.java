package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1010 {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        final List<SidePoint> sidePoints = new ArrayList<>();

        while (T-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            sidePoints.add(new SidePoint(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        String result = solve(sidePoints);
        System.out.println(result);
    }

    private static String solve(final List<SidePoint> sidePoints) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (SidePoint sidePoint : sidePoints) {
            int N = sidePoint.leftSide;
            int M = sidePoint.rightSide;

            int bridgeCount = combine(M, N);
            stringBuilder.append(bridgeCount).append("\n");
        }

        return stringBuilder.toString();
    }

    private static int combine(final int n, final int r) {

        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (r == n || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combine(n - 1, r - 1) + combine(n - 1, r);
    }

    private static class SidePoint {
        private int leftSide;
        private int rightSide;

        public SidePoint(final int leftSide, final int rightSide) {
            this.leftSide = leftSide;
            this.rightSide = rightSide;
        }
    }
}
