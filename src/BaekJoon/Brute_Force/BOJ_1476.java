package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1476 {
    private static final int YEAR_SIZE = 3;
    private static final int EARTH_RANGE = 15;
    private static final int SUN_RANGE = 28;
    private static final int MOON_RANGE = 19;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int[] year = new int[YEAR_SIZE];

        for (int i = 0; i < year.length; i++) {
            year[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = solution(year);
        System.out.println(result);
    }

    private static int solution(final int[] year) {
        int yearCount = 1;
        int[] compareYear = new int[year.length];

        Arrays.fill(compareYear, 1);

        while (isSameYear(year, compareYear)) {
            for (int i = 0; i < compareYear.length; i++) {
                compareYear[i]++;
            }

            yearCount++;
        }

        return yearCount;
    }

    private static boolean isSameYear(final int[] year, final int[] compareYear) {
        boolean isSameYear = false;

        for (int i = 0; i < year.length; i++) {
            if (year[i] != compareYear[i]) {
                isSameYear = true;
                break;
            }
        }

        if (compareYear[0] == EARTH_RANGE) {
            compareYear[0] = 0;
        }

        if (compareYear[1] == SUN_RANGE) {
            compareYear[1] = 0;
        }

        if (compareYear[2] == MOON_RANGE) {
            compareYear[2] = 0;
        }

        return isSameYear;
    }
}
