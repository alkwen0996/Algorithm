package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10872 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solve(N));
    }

    private static int solve(final int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * solve(n - 1);
        }
    }
}
