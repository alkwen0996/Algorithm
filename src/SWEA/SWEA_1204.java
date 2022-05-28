package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SWEA_1204 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SIGNAL = "#";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final int testCaseNumber = Integer.parseInt(bufferedReader.readLine());
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final List<Integer> usedNumbers = new ArrayList<>();
            for (int j = 1; j <= 1000; j++) {
                usedNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            final Map<Integer, Integer> usedNumbersCount = new HashMap<>();
            for (int j = 0; j <= 100; j++) {
                usedNumbersCount.put(j, 0);
            }

            stringBuilder.append(SIGNAL)
                    .append(testCaseNumber)
                    .append(SPACE)
                    .append(findMostUsedNumber(usedNumbers, usedNumbersCount))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int findMostUsedNumber(final List<Integer> usedNumbers, final Map<Integer, Integer> usedNumbersCount) {
        for (Integer usedNumber : usedNumbers) {
            usedNumbersCount.put(usedNumber, usedNumbersCount.get(usedNumber) + 1);
        }

        int maxValue = Collections.max(usedNumbersCount.values());
        int maxKey = 0;

        for (int usedNumber : usedNumbersCount.keySet()) {
            if (usedNumbersCount.get(usedNumber) == maxValue) {
                if (maxKey < usedNumber) {
                    maxKey = usedNumber;
                }
            }
        }

        return maxKey;
    }
}
