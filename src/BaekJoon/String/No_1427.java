package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1427 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = bufferedReader.readLine().toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(numbers);

        for (int i = numbers.length - 1; i >= 0; i--) {
            stringBuilder.append(numbers[i]);
        }

        System.out.println(stringBuilder.toString());

    }
}
