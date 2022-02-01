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
        final StringBuilder stringBuilder = new StringBuilder();
        int factorizationResult = n;
        int factorizationNumber = 2;

        while (factorizationResult != 1) {
            if (factorizationResult % factorizationNumber == 0) {
                factorizationResult /= factorizationNumber;
                stringBuilder.append(factorizationNumber).append(NEW_LINE);
            } else {
                factorizationNumber++;
            }
        }

        return stringBuilder.toString();
    }
}
