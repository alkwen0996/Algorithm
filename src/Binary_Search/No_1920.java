package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1920 {

    private static final String NEW_LINE = "\n";
    private static final String CONTAINS = "1";
    private static final String NOT_CONTAINS = "0";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(bufferedReader.readLine());
        final int[] haveNumbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            haveNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final int M = Integer.parseInt(bufferedReader.readLine());
        final int[] compareNumbers = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            compareNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        String result = solve(haveNumbers, compareNumbers);
        System.out.println(result);
    }

    private static String solve(final int[] haveNumbers, final int[] compareNumbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        Arrays.sort(haveNumbers);

        for (final int compareNumber : compareNumbers) {
            if (binarySearch(compareNumber, haveNumbers)) {
                stringBuilder.append(CONTAINS).append(NEW_LINE);
                continue;
            }
            stringBuilder.append(NOT_CONTAINS).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static boolean binarySearch(final int compareNumber, final int[] haveNumbers) {
        int leftIndex = 0;
        int rightIndex = haveNumbers.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midValue = haveNumbers[midIndex];

            if (midValue < compareNumber) {
                leftIndex = midIndex + 1;
            } else if (midValue > compareNumber) {
                rightIndex = midIndex - 1;
            } else {
                return true;
            }

        }

        return false;
    }
}
