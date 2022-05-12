package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int sequenceSize = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] sequence = new int[sequenceSize + 1];

        for (int i = 1; i <= sequenceSize; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(createMaximumValueOfSubSequence(sequenceSize, sequence));
    }

    private static int createMaximumValueOfSubSequence(final int sequenceSize, final int[] sequence) {
        final int[] memorization = new int[sequenceSize + 1];

        Arrays.fill(memorization, Integer.MIN_VALUE);

        memorization[1] = sequence[1];

        for (int i = 2; i < sequence.length; i++) {
            memorization[i] = Math.max(memorization[i - 1] + sequence[i], sequence[i]);
        }

        return Arrays.stream(memorization).max().getAsInt();
    }
}
