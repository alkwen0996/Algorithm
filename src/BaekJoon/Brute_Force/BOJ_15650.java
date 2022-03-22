package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static final StringBuilder stringBuilder = new StringBuilder();
    static int[] sequence = new int[10];

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        int index = 1;
        int selected = 0;

        findSequence(index, selected, n, m);
        System.out.println(stringBuilder);
    }

    private static void findSequence(final int index, final int selected, final int n, final int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(sequence[i]);

                if (i < m - 1) {
                    stringBuilder.append(SPACE);
                }
            }

            stringBuilder.append(NEW_LINE);
            return;
        }

        if (index > n) {
            return;
        }

        sequence[selected] = index;
        findSequence(index + 1, selected + 1, n, m);

        sequence[selected] = 0;
        findSequence(index + 1, selected, n, m);

    }
}
