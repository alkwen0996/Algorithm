package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int sequenceSize = Integer.parseInt(bufferedReader.readLine());

        int[] totalSequence = new int[sequenceSize + 1];
        final int[] sequenceSizeMemorization = new int[sequenceSize + 1];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= sequenceSize; i++) {
            totalSequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(createIncreasingPartialSequence(sequenceSize, totalSequence, sequenceSizeMemorization));
    }

    private static StringBuilder createIncreasingPartialSequence(final int sequenceSize, final int[] totalSequence, final int[] sequenceSizeMemorization) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (sequenceSize == 1) {
            stringBuilder.append(1)
                    .append(NEW_LINE)
                    .append(totalSequence[1]);

            return stringBuilder;
        }

        int increasingSequenceSize = 0;
        sequenceSizeMemorization[1] = 1;

        for (int i = 2; i < totalSequence.length; i++) {
            sequenceSizeMemorization[i] = 1;

            for (int j = 1; j < i; j++) {
                if (totalSequence[i] > totalSequence[j] && sequenceSizeMemorization[i] < sequenceSizeMemorization[j] + 1) {
                    sequenceSizeMemorization[i] = Math.max(sequenceSizeMemorization[i], sequenceSizeMemorization[j] + 1);
                }
            }

            increasingSequenceSize = Math.max(increasingSequenceSize, sequenceSizeMemorization[i]);
        }

        int[] indexMemorization = new int[increasingSequenceSize];
        int index = 0;
        int value = increasingSequenceSize;

        for (int i = sequenceSize; i >= 1; i--) {
            if (value == sequenceSizeMemorization[i]) {
                indexMemorization[index] = totalSequence[i];
                value--;
                index++;
            }
        }

        stringBuilder.append(increasingSequenceSize).append(NEW_LINE);

        for (int i = increasingSequenceSize - 1; i >= 0; i--) {
            stringBuilder.append(indexMemorization[i]).append(SPACE);
        }

        return stringBuilder;
    }
}
