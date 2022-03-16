package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1676 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int zeroCount = 0;

        while (n >= 5) {
            zeroCount += n / 5;
            n /= 5;
        }

        return zeroCount;
    }
}
