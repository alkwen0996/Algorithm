package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11441 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int countOfNumber = Integer.parseInt(bufferedReader.readLine());
        final int[] numbers = new int[countOfNumber];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < countOfNumber; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final int countOfRange = Integer.parseInt(bufferedReader.readLine());
        final List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < countOfRange; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int start = Integer.parseInt(stringTokenizer.nextToken());
            final int end = Integer.parseInt(stringTokenizer.nextToken());

            ranges.add(new Range(start, end));
        }

        System.out.println(calculateSumValues(countOfRange, numbers, ranges));
    }

    private static StringBuilder calculateSumValues(final int countOfRange, final int[] numbers, final List<Range> ranges) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfRange; i++) {
            final int start = ranges.get(i).start;
            final int end = ranges.get(i).end;

            int sum = 0;
            for (int j = start - 1; j < end; j++) {
                sum += numbers[j];
            }

            stringBuilder.append(sum).append(NEW_LINE);
        }

        return stringBuilder;
    }

    static class Range {
        private int start;
        private int end;

        public Range(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }

}
