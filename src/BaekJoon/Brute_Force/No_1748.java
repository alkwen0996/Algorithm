package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1748 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(final int n) {
        int numberOfDigit = 0;
        int checkOneDigitNumber = 10;
        int eachNumberOfDigit = 1;

        for (int i = 1; i <= n; i++) {
            if (i % checkOneDigitNumber == 0) {
                eachNumberOfDigit++;
                checkOneDigitNumber *= 10;
            }

            numberOfDigit += eachNumberOfDigit;
        }

        return numberOfDigit;
    }
}
