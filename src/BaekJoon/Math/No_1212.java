package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1212 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String octalNumber = bufferedReader.readLine();

        char[] octalNumbers = octalNumber.toCharArray();

        String result = solve(octalNumber);
        System.out.println(result);
    }

    private static String solve(final String octalNumbers) {
        int sum = 0;
        int len = octalNumbers.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < octalNumbers.length(); i++) {
            String binaryString = Integer.toBinaryString(octalNumbers.charAt(i) - '0');

            if (binaryString.length() == 2 && i != 0) {
                binaryString = "0" + binaryString;
            } else if (binaryString.length() == 1 && i != 0) {
                binaryString = "00" + binaryString;
            }

            stringBuilder.append(binaryString);
        }

        return stringBuilder.toString();
    }
}
