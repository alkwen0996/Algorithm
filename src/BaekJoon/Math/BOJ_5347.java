package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5347 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOftestCase = Integer.parseInt(bufferedReader.readLine());

        final List<NumberRange> numbers = new ArrayList<>();

        for (int i = 0; i < numberOftestCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startNumber = Integer.parseInt(stringTokenizer.nextToken());
            int endNumber = Integer.parseInt(stringTokenizer.nextToken());

            numbers.add(new NumberRange(startNumber, endNumber));
        }

        System.out.println(solution(numbers));
    }

    private static StringBuilder solution(final List<NumberRange> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (NumberRange number : numbers) {
            final long startNumber = number.startNumber;
            final long endNumber = number.endNumber;

            long gcd = getGcd(startNumber, endNumber);
            long lcm = startNumber * endNumber / gcd;
            stringBuilder.append(lcm).append(NEW_LINE);
        }

        return stringBuilder;
    }

    private static long getGcd(final long startNumber, final long endNumber) {
        if (endNumber == 0) {
            return startNumber;
        }

        return getGcd(endNumber, startNumber % endNumber);
    }


    private static class NumberRange {
        private int startNumber;
        private int endNumber;

        public NumberRange(final int startNumber, final int endNumber) {
            this.startNumber = startNumber;
            this.endNumber = endNumber;
        }
    }

}
