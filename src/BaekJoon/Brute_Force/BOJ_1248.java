package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248 {
    private static final String SPACE = " ";

    private static int n;
    private static int[][] signBoard;
    private static int[] guessNumbers;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        final String signs = bufferedReader.readLine();
        signBoard = new int[n][n];
        guessNumbers = new int[n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char sign = signs.charAt(index);

                if (sign == '0') {
                    signBoard[i][j] = 0;
                } else if (sign == '+') {
                    signBoard[i][j] = 1;
                } else {
                    signBoard[i][j] = -1;
                }

                index++;
            }
        }

        findNumbers(0);

        final StringBuilder stringBuilder = new StringBuilder();

        for (final int guessNumber : guessNumbers) {
            stringBuilder.append(guessNumber).append(SPACE);
        }

        System.out.println(stringBuilder);
    }

    private static boolean findNumbers(final int index) {
        if (index == n) {
            return true;
        }

        if (signBoard[index][index] == 0) {
            guessNumbers[index] = 0;
            findNumbers(index + 1);

            return check(index) && findNumbers(index + 1);
        }

        for (int i = 1; i <= 10; i++) {
            guessNumbers[index] = signBoard[index][index] * i;
            if (check(index) && findNumbers(index + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean check(final int index) {
        int sum = 0;

        for (int i = index; i >= 0; i--) {
            sum += guessNumbers[i];

            if (signBoard[i][index] == 0) {
                if (sum != 0) {
                    return false;
                }
            } else if (signBoard[i][index] < 0) {
                if (sum >= 0) {
                    return false;
                }
            } else if (signBoard[i][index] > 0) {
                if (sum <= 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
