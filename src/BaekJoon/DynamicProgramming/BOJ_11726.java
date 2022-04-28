package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        memorization = new int[1002];
        memorization[1] = 1;
        memorization[2] = 2;

        System.out.println(findWayToFillRectangle(n));
    }

    private static int findWayToFillRectangle(final int n) {
        if (n <= 2) {
            return memorization[n];
        }

        for (int i = 3; i <= n; i++) {
            memorization[i] = (memorization[i - 1] + memorization[i - 2]) % 10_007;
        }

        return memorization[n];
    }

}
