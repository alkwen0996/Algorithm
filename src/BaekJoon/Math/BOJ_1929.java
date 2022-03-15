package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int m = Integer.parseInt(stringTokenizer.nextToken());
        final int n = Integer.parseInt(stringTokenizer.nextToken());

        String result = solution(m, n);
        System.out.println(result);
    }

    private static String solution(final int m, final int n) {
        boolean[] checkPrimeNumber = checkPrimeNumber(m, n);
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = m; i <= n; i++) {
            if (!checkPrimeNumber[i]) {
                stringBuilder.append(i).append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean[] checkPrimeNumber(final int m, final int n) {
        boolean[] checkPrimeNumber = new boolean[1_000_001];

        checkPrimeNumber[0] = true;
        checkPrimeNumber[1] = true;

        for (int i = 2; i < checkPrimeNumber.length; i++) {
            for (int j = i + i; j < checkPrimeNumber.length; j += i) {
                if (checkPrimeNumber[j]) {
                    continue;
                }

                checkPrimeNumber[j] = true;
            }
        }

        return checkPrimeNumber;
    }

}
