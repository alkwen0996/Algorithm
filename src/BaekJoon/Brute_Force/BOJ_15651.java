package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static final StringBuilder stringBuilder = new StringBuilder();
    static boolean[] useNumber = new boolean[10];
    static int[] sequence = new int[10];

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        int index = 0;

        findSequence(index, n, m);
        System.out.println(stringBuilder.toString());
    }

    private static void findSequence(final int index, final int n, final int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(sequence[i]);

                if (i < m - 1) {
                    stringBuilder.append(SPACE);
                }
            }

            stringBuilder.append(NEW_LINE);
            return;
        }

        for (int i = 1; i <= n; i++) {
            useNumber[i] = true;
            sequence[index] = i;
            findSequence(index + 1, n, m);
            useNumber[i] = false;
        }

    }
}
