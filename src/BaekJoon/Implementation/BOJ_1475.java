package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roomNumber = Integer.parseInt(bufferedReader.readLine());

        final int[] countOfNumbers = new int[10];

        while (roomNumber > 0) {
            int index = roomNumber % 10;

            if (index == 6 || index == 9) {
                countOfNumbers[6]++;
            } else {
                countOfNumbers[index]++;
            }

            roomNumber /= 10;
        }

        if (countOfNumbers[6] >= 2) {
            if (countOfNumbers[6] % 2 == 0) {
                countOfNumbers[6] /= 2;
            } else {
                countOfNumbers[6] = (countOfNumbers[6] / 2) + 1;
            }
        }

        System.out.println(Arrays.stream(countOfNumbers).max().getAsInt());
    }
}
