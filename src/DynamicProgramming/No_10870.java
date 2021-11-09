package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10870 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        if (n == 0) {
            System.out.println(0);
        } else {
            solve(n);
        }
    }

    private static void solve(final int n) {
        final int[] numbers = new int[n + 1];

        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.println(numbers[numbers.length - 1]);
    }
}
