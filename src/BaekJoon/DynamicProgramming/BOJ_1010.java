package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {

    private static int[][] memorization;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();
        memorization = new int[30][30];

        for (int i = 0; i < testCaseCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int leftBridgePointCount = Integer.parseInt(stringTokenizer.nextToken());
            final int rightBridgePointCount = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(countBridge(rightBridgePointCount, leftBridgePointCount)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int countBridge(final int rightPointCount, final int leftPointCount) {
        if (memorization[rightPointCount][leftPointCount] > 0) {
            return memorization[rightPointCount][leftPointCount];
        }

        if (rightPointCount == leftPointCount || leftPointCount == 0) {
            return memorization[rightPointCount][leftPointCount] = 1;
        }

        memorization[rightPointCount][leftPointCount] = countBridge(rightPointCount - 1, leftPointCount - 1) + countBridge(rightPointCount - 1, leftPointCount);
        return memorization[rightPointCount][leftPointCount];
    }

}
