package BaekJoon.Brute_Force.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    private static int count = 0;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int numberCount = Integer.parseInt(stringTokenizer.nextToken());
        final int targetValue = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        numbers = new int[numberCount];

        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int index = 0;
        int sum = 0;

        findSumOfPermutation(targetValue, index, sum);

        if (targetValue == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static void findSumOfPermutation(final int targetValue, final int index, final int sum) {
        if (index == numbers.length) {
            if (sum == targetValue) {
                count++;
            }

            return;
        }

        findSumOfPermutation(targetValue, index + 1, sum + numbers[index]);
        findSumOfPermutation(targetValue, index + 1, sum);
    }

}
