package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SWEA_2072 {

    private static final String NEW_LINE = "\n";
    private static final String SIGNAL = "#";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                final int number = Integer.parseInt(stringTokenizer.nextToken());

                if ((number % 2) == 1) {
                    numbers.add(number);
                }
            }

            int eachLineSum = numbers.stream()
                    .mapToInt(a -> a)
                    .sum();
            stringBuilder.append(SIGNAL).append(i + 1).append(SPACE).append(eachLineSum).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }
}
