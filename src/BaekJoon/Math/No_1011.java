package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1011 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int lineCount = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lineCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(solve(x, y)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solve(final int x, final int y) {
        int distance = y - x;
        int count = 0;

        int max = (int) Math.sqrt(distance);
        if (max == Math.sqrt(distance)) {
            count = (2 * max) - 1;
        } else if (distance <= (max * max) + max) {
            count = 2 * max;
        } else {
            count = (2 * max) + 1;
        }

        return count;
    }
}
