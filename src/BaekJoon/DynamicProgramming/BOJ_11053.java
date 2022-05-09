package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {

    private static final int NUMBER_MAXIMUM_RANGE = 1001;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int sequenceSize = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int[] sequence = new int[sequenceSize + 1];
        final int[] memorization = new int[NUMBER_MAXIMUM_RANGE];

        for (int i = 1; i <= sequenceSize; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(countIncreasingSequenceSize(sequenceSize, sequence, memorization));
    }

    private static int countIncreasingSequenceSize(final int sequenceSize, final int[] sequence, final int[] memorization) {
        if (sequenceSize == 1) {
            return 1;
        }

        int increasingSequenceSize = 0;
        memorization[1] = 1;

        for (int i = 2; i < sequence.length; i++) {
            memorization[i] = 1;

            for (int j = 1; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    memorization[i] = Math.max(memorization[i], memorization[j] + 1);
                }
            }

            increasingSequenceSize = Math.max(increasingSequenceSize, memorization[i]);
        }

        return increasingSequenceSize;
    }

}
