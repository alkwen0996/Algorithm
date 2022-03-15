package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] inputNumbers = new int[N];

        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = solution(inputNumbers);
        System.out.println(result);
    }

    private static int solution(final int[] inputNumbers) {
        boolean[] checkPrimeNumber = checkPrimeNumber();

        return countPrimeNumber(inputNumbers, checkPrimeNumber);
    }

    private static int countPrimeNumber(final int[] inputNumbers, final boolean[] checkPrimeNumber) {
        int count = 0;

        for (final int inputNumber : inputNumbers) {
            for (int j = 0; j < checkPrimeNumber.length; j++) {
                if (inputNumber == j) {
                    if (!checkPrimeNumber[j]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean[] checkPrimeNumber() {
        boolean[] checkPrimeNumber = new boolean[1001];

        checkPrimeNumber[0] = true;
        checkPrimeNumber[1] = true;

        for (int i = 2; i < checkPrimeNumber.length; i++) {
            for (int j = i + i; j < checkPrimeNumber.length; j += i) {
                if (checkPrimeNumber[j]) {
                    continue;
                }

                checkPrimeNumber[j] = true;
            }
        }

        return checkPrimeNumber;
    }
}
