package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_6588 {
    private static final String NEW_LINE = "\n";
    private static final String WRONG_MESSAGE = "Goldbach's conjecture is wrong.";
    private static final String ZERO = "0";
    private static final String EQUALS_SIGN = " = ";
    private static final String PLUS = " + ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primeNumber = findPrimeNumber();

        String inputLine = "";
        final StringBuilder stringBuilder = new StringBuilder();
        while (!(inputLine = bufferedReader.readLine()).equals(ZERO)) {
            int testCase = Integer.parseInt(inputLine);
            boolean check = false;

            for (int i = 2; i <= testCase / 2; i++) {
                if (!primeNumber[i] && !primeNumber[testCase - i]) {
                    stringBuilder.append(testCase)
                            .append(EQUALS_SIGN)
                            .append(i)
                            .append(PLUS)
                            .append(testCase - i)
                            .append(NEW_LINE);

                    check = true;
                    break;
                }
            }

            if (!check) {
                stringBuilder.append(WRONG_MESSAGE);
            }
        }

        System.out.println(stringBuilder);
    }

    private static boolean[] findPrimeNumber() {
        boolean[] primeNumber = new boolean[100_000_1];

        primeNumber[0] = true;
        primeNumber[1] = true;

        for (int i = 2; i < primeNumber.length; i++) {
            for (int j = i + i; j < primeNumber.length; j += i) {
                if (primeNumber[j]) {
                    continue;
                }

                if (!primeNumber[j]) {
                    primeNumber[j] = true;
                }
            }
        }

        return primeNumber;
    }
}
