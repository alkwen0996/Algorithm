package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14729 {

    private static final String NEW_LINE = "\n";
    private static final String FORMAT = "%.3f";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfStudents = Integer.parseInt(bufferedReader.readLine());

        final float[] scores = new float[countOfStudents];

        for (int i = 0; i < countOfStudents; i++) {
            scores[i] = Float.parseFloat(bufferedReader.readLine());
        }

        System.out.println(solve(scores));
    }

    private static StringBuilder solve(final float[] scores) {
        Arrays.sort(scores);

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            stringBuilder.append(String.format(FORMAT, scores[i])).append(NEW_LINE);
        }

        return stringBuilder;
    }

}
