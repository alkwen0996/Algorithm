package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_14729 {

    private static final String NEW_LINE = "\n";
    private static final String FORMAT = "%.3f";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfStudents = Integer.parseInt(bufferedReader.readLine());

        final float[] scores = new float[10_000_001];

        for (int i = 0; i < countOfStudents; i++) {
            scores[(int) (Float.parseFloat(bufferedReader.readLine()) * 1000)]++;
        }

        final StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < scores.length; i++) {
            while (scores[i] > 0 && count < 7) {
                stringBuilder.append(String.format(FORMAT, i / 1000.0)).append(NEW_LINE);
                count++;
                scores[i]--;
            }
        }

        System.out.println(stringBuilder);
    }

}
