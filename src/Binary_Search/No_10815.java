package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_10815 {
    private static final String SPACE = " ";
    private static final int CONTAINS_SYMBOL = 1;
    private static final int NO_CONTAINS_SYMBOL = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        final int[] haveNumbers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            haveNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        final int[] compareNumbers = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            compareNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(haveNumbers);

        String result = solve(haveNumbers, compareNumbers);
        System.out.println(result);

    }

    private static String solve(final int[] haveNumbers, final int[] compareNumbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int compareNumber : compareNumbers) {
            if (binarySearch(haveNumbers, compareNumber)) {
                stringBuilder.append(CONTAINS_SYMBOL).append(SPACE);
                continue;
            }

            stringBuilder.append(NO_CONTAINS_SYMBOL).append(SPACE);
        }

        return stringBuilder.toString();
    }

    private static boolean binarySearch(final int[] haveNumbers, final int compareNumber) {
        int leftIndex = 0;
        int rightIndex = haveNumbers.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midValue = haveNumbers[midIndex];

            if (compareNumber > midValue) {
                leftIndex = midIndex + 1;
            } else if (compareNumber < midValue) {
                rightIndex = midIndex - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
