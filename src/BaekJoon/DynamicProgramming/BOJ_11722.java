package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 {

    private static int maximumLengthOfSubSequence = 0;
    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfSequence = Integer.parseInt(bufferedReader.readLine());

        final int[] sequence = new int[numberOfSequence];
        memorization = new int[numberOfSequence];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < numberOfSequence; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < sequence.length; i++) {
            int index = 0;
            int subSequenceLength = 0;
            findSubSequence(i, index, subSequenceLength, sequence);
        }

        System.out.println(maximumLengthOfSubSequence);
    }

    private static void findSubSequence(final int startIndex, int index, int subSequenceLength, final int[] sequence) {

    }

}
