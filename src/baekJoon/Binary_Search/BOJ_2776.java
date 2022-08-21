package baekJoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2776 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final int note1Count = Integer.parseInt(bufferedReader.readLine());
            final int[] note1 = new int[note1Count];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < note1Count; j++) {
                final int data1 = Integer.parseInt(stringTokenizer.nextToken());
                note1[j] = data1;
            }

            Arrays.sort(note1);

            final int note2Count = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < note2Count; j++) {
                stringBuilder.append(binarySearch(note1, Integer.parseInt(stringTokenizer.nextToken()))).append(NEW_LINE);
            }
        }

        System.out.println(stringBuilder);
    }

    private static int binarySearch(final int[] note1, final int target) {
        int start = 0;
        int end = note1.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == note1[mid]) {
                return 1;
            }

            if (target > note1[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }

}
