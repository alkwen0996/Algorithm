package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002 {

    private static final int NUMBER_MAXIMUM_RANGE = 1001;
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int sequenceSize = Integer.parseInt(bufferedReader.readLine());

        int[] totalSequence = new int[sequenceSize + 1];
        final int[] memorization = new int[NUMBER_MAXIMUM_RANGE];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= sequenceSize; i++) {
            totalSequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(createIncreasingPartialSequence(sequenceSize, totalSequence, memorization));
    }

    private static StringBuilder createIncreasingPartialSequence(final int sequenceSize, final int[] totalSequence, final int[] memorization) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (sequenceSize == 1) {
            stringBuilder.append(1)
                    .append(NEW_LINE)
                    .append(totalSequence[1]);

            return stringBuilder;
        }

        int increasingSequenceSize = 0;
        memorization[1] = 1;

        for (int i = 2; i < totalSequence.length; i++) {
            memorization[i] = 1;

            for (int j = 1; j < i; j++) {
                if (totalSequence[i] > totalSequence[j]) {
                    memorization[i] = Math.max(memorization[i], memorization[j] + 1);
                }
            }

            increasingSequenceSize = Math.max(increasingSequenceSize, memorization[i]);
        }

        stringBuilder.append(increasingSequenceSize).append(NEW_LINE);

        int index = 1;

        for (int i = 1; i < memorization.length; i++) {
            if (index == memorization[i]) {
                stringBuilder.append(totalSequence[i]).append(SPACE);
                index++;
            }
        }

        return stringBuilder;
    }
}
