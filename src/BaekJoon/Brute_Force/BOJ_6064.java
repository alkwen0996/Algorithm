package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int lastX = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int lastY = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            stringBuilder.append(solution(m, n, lastX, lastY)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solution(final int m, final int n, final int lastX, final int lastY) {
        int yearCount = 0;
        boolean isOk = true;

        for (int i = lastX; i < m * n; i += m) {
            if (i % n == lastY) {
                yearCount = i + 1;
                isOk = false;
                break;
            }
        }

        if (isOk) {
            return -1;
        }

        return yearCount;
    }
}
