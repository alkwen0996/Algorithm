package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int inputNaturalNumber = Integer.parseInt(bufferedReader.readLine());

        System.out.println(countMinimumNumber(inputNaturalNumber));
    }

    private static int countMinimumNumber(final int inputNaturalNumber) {
        int[] memorization = new int[100_001];

        for (int i = 1; i <= inputNaturalNumber; i++) {
            memorization[i] = i;

            for (int j = 1; j * j <= i; j++) {
                memorization[i] = Math.min(memorization[i], memorization[i - j * j] + 1);
            }
        }

        return memorization[inputNaturalNumber];
    }
}
