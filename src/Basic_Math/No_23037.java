package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_23037 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String inputNumber = bufferedReader.readLine();

        int result = solve(inputNumber);
        System.out.println(result);
    }

    private static int solve(final String inputNumber) {
        char[] numbers = inputNumber.toCharArray();

        int sum = 0;
        for (final char c : numbers) {
            int number = c - '0';
            sum += pow(number);
        }

        return sum;
    }

    private static int pow(final int number) {
        int pow = 1;
        for (int i = 0; i < 5; i++) {
            pow = pow * number;
        }
        return pow;
    }
}
