package BasicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4948 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();

        int input = 0;
        while ((input = Integer.parseInt(bufferedReader.readLine())) != 0) {
            stringBuilder.append(solve(input)).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solve(final int input) {
        boolean[] checkPrime = new boolean[(2 * input) + 1];

        checkPrime[0] = false;
        checkPrime[1] = false;

        for (int i = 2; i < checkPrime.length; i++) {
            checkPrime[i] = true;
        }

        for (int i = 2; i <= 2 * input; i++) {
            for (int j = i + i; j <= 2 * input; j += i) {
                if (!checkPrime[j]) {
                    continue;
                }
                if (checkPrime[j]) {
                    checkPrime[j] = false;
                }
            }
        }

        int primeCount = 0;
        for (int i = input + 1; i <= input * 2; i++) {
            if (checkPrime[i]) {
                primeCount++;
            }
        }

        return primeCount;
    }
}
