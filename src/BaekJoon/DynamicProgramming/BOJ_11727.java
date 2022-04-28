package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        memorization = new int[10_007];
        memorization[1] = 1;
        memorization[2] = 3;

        int index = 3;
        findWayToFillRectangle(n, index);
        System.out.println(memorization[n]);
    }

    private static void findWayToFillRectangle(final int n, final int index) {
        if (n <= 2) {
            return;
        }

        if (index > n) {
            return;
        }

        memorization[index] = (memorization[index - 1] + (2 * memorization[index - 2])) % 10_007;
        findWayToFillRectangle(n, index + 1);
    }

}
