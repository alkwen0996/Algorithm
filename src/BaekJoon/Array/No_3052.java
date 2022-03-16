package BaekJoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_3052 {
    public static final int COUNT_INPUT_NUMBERS = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputNumbers = new int[COUNT_INPUT_NUMBERS];

        for (int i = 0; i < COUNT_INPUT_NUMBERS; i++) {
            inputNumbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] divides = divisionInputNumbers(inputNumbers);

        System.out.println(Arrays.stream(divides).distinct().count());
    }

    private static int[] divisionInputNumbers(int[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = inputNumbers[i] % 42;
        }

        return inputNumbers;
    }
}
