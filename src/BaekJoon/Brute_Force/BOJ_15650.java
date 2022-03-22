package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
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
        int start = 1;

        findSequence(index, start, n, m);
        System.out.println(stringBuilder.toString());
    }

    private static void findSequence(final int index, final int start, final int n, final int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(sequence[i]);

                if (i < m - 1) {
                    stringBuilder.append(SPACE);
                }
            }

            stringBuilder.append(NEW_LINE);
        }

        for (int i = start; i <= n; i++) { // start는 i+1을 의미하기 때문에 항상 수열이 다음 자리는 start부터 시작.
            if (useNumber[i]) {
                continue;
            }

            useNumber[i] = true;
            sequence[index] = i;

            findSequence(index + 1, i + 1, n, m); // 수열의 다음 index 숫자는 기존에 들어간 i보다 커야한다. (수열이 오름차순이 되어야 한다.)
            useNumber[i] = false;
        }
    }

}
