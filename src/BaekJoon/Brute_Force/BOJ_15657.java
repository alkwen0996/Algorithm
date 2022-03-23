package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15657 {
    private static final boolean[] useNumbers = new boolean[10_000];
    private static final int[] sequences = new int[10];
    private static final StringBuilder stringBuilder = new StringBuilder();

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        final List<Integer> sequenceNumbers = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            sequenceNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(sequenceNumbers);
        int index = 0;
        int start = 0;

        findSequence(start, index, n, m, sequenceNumbers);
        System.out.println(stringBuilder);
    }

    private static void findSequence(int start, final int index, final int n, final int m, final List<Integer> sequenceNumbers) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(sequences[i]);

                if (i < m - 1) {
                    stringBuilder.append(SPACE);
                }
            }

            stringBuilder.append(NEW_LINE);
            return;
        }

        for (int i = start; i < sequenceNumbers.size(); i++) {
            useNumbers[sequenceNumbers.get(i)] = true;
            sequences[index] = sequenceNumbers.get(i);
            start = i;
            findSequence(start, index + 1, n, m, sequenceNumbers);
            useNumbers[sequenceNumbers.get(i)] = false;
        }

    }
}
