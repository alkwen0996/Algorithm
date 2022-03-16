package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2748 {
    private static long[] fibonacci;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        fibonacci = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            fibonacci[i] = -1;
        }

        long result = solve(n);
        System.out.println(result);
    }

    private static long solve(final int n) {
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        return fibonacci(n);
    }

    private static long fibonacci(final int n) {
        if (fibonacci[n] == -1) {
            fibonacci[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return fibonacci[n];
    }
}
