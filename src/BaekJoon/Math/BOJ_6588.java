package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    private static final String NEW_LINE = "\n";
    private static final String ZERO = "0";
    private static final String GOLDBACH_S_CONJECTURE_IS_WRONG = "Goldbach's conjecture is wrong.";
    private static final String PLUS_SIGN = " + ";
    private static final String EQUALS_SIGN = " = ";
    private static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String testCase = "";

        final StringBuilder stringBuilder = new StringBuilder();
        boolean[] checkPrimeNumber = findPrimeNumber();
        boolean checkWrong = true;

        while (!(testCase = bufferedReader.readLine()).equals(ZERO)) {
            final int testCaseToNumber = Integer.parseInt(testCase);

            for (int i = 0; i < checkPrimeNumber.length; i++) {
                if (!checkPrimeNumber[i] && !checkPrimeNumber[testCaseToNumber-i]) {
                    stringBuilder.append(testCase)
                            .append(EQUALS_SIGN)
                            .append(i)
                            .append(PLUS_SIGN)
                            .append(testCaseToNumber - i)
                            .append(NEW_LINE);

                    checkWrong = false;
                    break;
                }
            }

            if(checkWrong){
                stringBuilder.append(GOLDBACH_S_CONJECTURE_IS_WRONG)
                        .append(NEW_LINE);
            }
        }

        System.out.println(stringBuilder);
    }

    private static boolean[] findPrimeNumber() {
        boolean[] checkPrimeNumber = new boolean[MAX];
        checkPrimeNumber[0] = checkPrimeNumber[1] = true;

        for (int i = 2; i < checkPrimeNumber.length; i++) {
            if (checkPrimeNumber[i]) {
                continue;
            }

            for (int j = i + i; j < checkPrimeNumber.length; j += i) {
                checkPrimeNumber[j] = true;
            }
        }

        return checkPrimeNumber;
    }
}
