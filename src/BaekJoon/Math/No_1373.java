package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1373 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String binaryNumber = bufferedReader.readLine();

        System.out.println(solve(binaryNumber));
    }

    private static String solve(final String binaryNumber) {
        char[] binaryNumbers = binaryNumber.toCharArray();
        int unitNumberLength = binaryNumbers.length % 3;

        final StringBuilder stringBuilder = new StringBuilder();

        if (unitNumberLength == 1) {
            stringBuilder.append(binaryNumbers[0] - '0');
        } else if (unitNumberLength == 2) {
            stringBuilder.append((binaryNumbers[0] - '0') * 2 + (binaryNumbers[1] - '0'));
        }

        for (int i = unitNumberLength; i < binaryNumbers.length; i += 3) {
            stringBuilder.append((binaryNumbers[i] - '0') * 4 + (binaryNumbers[i + 1] - '0') * 2 + (binaryNumbers[i + 2] - '0'));
        }

        return stringBuilder.toString();
    }
}
