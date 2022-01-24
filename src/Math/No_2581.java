package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No_2581 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bufferedReader.readLine());
        int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solve(M, N));
    }

    private static String solve(final int m, final int n) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<Integer> primeNumber = new ArrayList<>();
        boolean[] checkPrimeNumber = isPrime(n);

        for (int i = m; i < checkPrimeNumber.length; i++) {
            if (checkPrimeNumber[i]) {
                primeNumber.add(i);
            }
        }

        int sum = primeNumber
                .stream()
                .mapToInt(a -> a)
                .sum();

        if (sum == 0) {
            return "-1";
        }

        int min = primeNumber
                .stream()
                .min(Comparator.comparingInt(a -> a))
                .get();

        return stringBuilder.append(sum).append("\n").append(min).toString();
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
