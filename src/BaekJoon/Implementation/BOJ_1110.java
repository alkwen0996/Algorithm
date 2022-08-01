package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int inputNumber = Integer.parseInt(bufferedReader.readLine());

        System.out.println(calculateCycleLength(inputNumber));
    }

    private static int calculateCycleLength(final int inputNumber) {
        int cycleNumber = inputNumber;
        int count = 0;
        int sumNumber = 0;
        int rightNumber = 0;

        do {
            if (cycleNumber < 10) {
                sumNumber = cycleNumber;
                rightNumber = cycleNumber;
            }

            if (cycleNumber >= 10) {
                sumNumber = (cycleNumber / 10) + (cycleNumber % 10);
                rightNumber = (cycleNumber % 10);
            }

            cycleNumber = (rightNumber * 10) + (sumNumber % 10);
            count++;
        } while (cycleNumber != inputNumber);

        return count;
    }

}
