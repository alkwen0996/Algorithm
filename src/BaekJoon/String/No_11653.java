package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11653 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        String result = solve(n);
        System.out.println(result);
    }

    private static String solve(final int n) {
        final boolean[] primeNumbers = findPrimeNumber(n);
        final StringBuilder stringBuilder = new StringBuilder();

        int factorizationResult = n;

        for (int i = 0; i < primeNumbers.length; i++) {
            while(!primeNumbers[i] && (factorizationResult % i == 0)){
                factorizationResult = factorizationResult / i;
                stringBuilder.append(i).append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean[] findPrimeNumber(final int n) {
        boolean[] primeNumbers = new boolean[n + 1];

        primeNumbers[0] = primeNumbers[1] = true;
        for (int i = 2; i < primeNumbers.length; i++) {
            for (int j = i + i; j < primeNumbers.length; j += i) {
                if (primeNumbers[j]) {
                    continue;
                }

                if (!primeNumbers[j]) {
                    primeNumbers[j] = true;
                }
            }
        }

        return primeNumbers;
    }
}
