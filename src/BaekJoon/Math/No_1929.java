package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1929 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int m = Integer.parseInt(stringTokenizer.nextToken());
        final int n = Integer.parseInt(stringTokenizer.nextToken());

        String result = solve(m, n);
        System.out.println(result);
    }

    private static String solve(final int m, final int n) {
        final StringBuilder stringBuilder = new StringBuilder();

        boolean[] primeNumber = isPrime(n);

        for (int i = m; i <= n; i++) {
            if (primeNumber[i]) {
                stringBuilder.append(i).append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean[] isPrime(final int n) {
        boolean[] primeNumber = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            primeNumber[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                if (!primeNumber[j]) {
                    continue;
                }

                if (primeNumber[j]) {
                    primeNumber[j] = false;
                }
            }
        }

        return primeNumber;
    }
}
