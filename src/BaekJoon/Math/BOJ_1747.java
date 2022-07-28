package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1747 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int input = Integer.parseInt(bufferedReader.readLine());

        System.out.println(findMinimumPrimeAndPalindrome(input));
    }

    private static int findMinimumPrimeAndPalindrome(final int input) {
        int minimumPrimeAndPalindromeNumber = 0;
        final boolean[] checkNumbers = new boolean[2_000_001];

        Arrays.fill(checkNumbers, true);
        checkNumbers[0] = false;
        checkNumbers[1] = false;

        checkPrime(checkNumbers);
        checkPalindrome(checkNumbers);

        for (int i = 1; i < checkNumbers.length; i++) {
            if (i >= input && checkNumbers[i]) {
                minimumPrimeAndPalindromeNumber = i;
                break;
            }
        }

        return minimumPrimeAndPalindromeNumber;
    }

    private static void checkPrime(final boolean[] checkNumbers) {
        for (int i = 2; i < checkNumbers.length; i++) {
            for (int j = i + i; j < checkNumbers.length; j += i) {
                if (!checkNumbers[j]) {
                    continue;
                }

                checkNumbers[j] = false;
            }
        }
    }

    private static void checkPalindrome(final boolean[] checkNumbers) {
        for (int i = 1; i < checkNumbers.length; i++) {
            final String number = String.valueOf(i);

            int right = number.length() - 1;
            int left = 0;

            while (left < number.length() && right >= 0) {
                if (number.charAt(right) != number.charAt(left)) {
                    checkNumbers[i] = false;
                    break;
                }

                right--;
                left++;
            }
        }

    }

}
