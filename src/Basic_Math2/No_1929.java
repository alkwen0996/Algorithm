package Basic_Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1929 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        String result = solve(m, n);
        System.out.println(result);
    }

    private static String solve(final int m, final int n) {
        final StringBuilder stringBuilder = new StringBuilder();
        boolean[] checkPrimeNumber = isPrime(n);

        for (int i = m; i < checkPrimeNumber.length; i++) {
            if (checkPrimeNumber[i]) {
                stringBuilder.append(i).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    private static boolean[] isPrime(final int n) {
        boolean[] checkPrime = new boolean[n + 1];

        checkPrime[0] = false;
        checkPrime[1] = false;

        for (int i = 2; i < checkPrime.length; i++) {
            checkPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                if (!checkPrime[j]) {
                    continue;
                }
                if (checkPrime[j]) {
                    checkPrime[j] = false;
                }
            }
        }

        return checkPrime;
    }
}
