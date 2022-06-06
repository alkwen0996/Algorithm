package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2071 {

    private static final String NEW_LINE = "\n";
    private static final String SIGNAL = "#";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final List<Integer> testCaseNumbers = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                testCaseNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringBuilder.append(SIGNAL)
                    .append(i + 1)
                    .append(SPACE)
                    .append(calculateAverage(testCaseNumbers))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int calculateAverage(final List<Integer> testCaseNumbers) {
        return (int) Math.round(testCaseNumbers.stream().mapToInt(a -> a).average().getAsDouble());
    }
}
