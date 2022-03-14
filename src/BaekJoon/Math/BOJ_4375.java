package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    private static final String NEW_LINE = "\n";
    private static final String BLANK = "";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String readLine = "";
        final StringBuilder stringBuilder = new StringBuilder();

        while ((readLine = bufferedReader.readLine()) != null) {
            if (readLine.equals(BLANK)) {
                break;
            }

            stringBuilder.append(solution(readLine)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solution(final String readLine) {
        final int testCase = Integer.parseInt(readLine);
        int number = 1;
        int numberLength = 1;

        while (number % testCase != 0) {
            number = number * 10 + 1;
            number %= testCase;
            numberLength++;
        }

        return numberLength;
    }
}
