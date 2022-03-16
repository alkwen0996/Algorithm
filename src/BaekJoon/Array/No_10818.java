package BaekJoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countNumber = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int[] numbers = new int[countNumber];

        for (int i = 0; i < countNumber; i++) {
            numbers[i] =Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println((findMinimum(numbers))+" "+findMaximum(numbers));
    }

    private static int findMinimum(int[] numbers) {
        return Arrays.stream(numbers)
                .min()
                .getAsInt();
    }

    private static int findMaximum(int[] numbers) {
        return Arrays.stream(numbers)
                .max()
                .getAsInt();
    }
}
