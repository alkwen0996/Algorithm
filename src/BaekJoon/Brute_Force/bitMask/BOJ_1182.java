package BaekJoon.Brute_Force.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int numberCount = Integer.parseInt(stringTokenizer.nextToken());
        final int targetValue = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int[] numbers = new int[numberCount];

        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int count = findSumOfPermutation(numbers, targetValue);

        if (targetValue == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static int findSumOfPermutation(final int[] numbers, final int targetValue) {
        int count = 0;

        for (int i = 0; i < (1 << numbers.length); i++) {
            int sum = 0;

            for (int j = 0; j < numbers.length; j++) {
                if((i & (1<<j)) != 0){
                    sum += numbers[j];
                }
            }

            if(sum == targetValue){
                count++;
            }
        }

        return count;
    }

}
