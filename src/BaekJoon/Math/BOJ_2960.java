package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int K = Integer.parseInt(stringTokenizer.nextToken());

        final boolean[] numbers = new boolean[N + 1];
        System.out.println(findNumbers(numbers, N, K));
    }

    private static int findNumbers(final boolean[] numbers, final int n, final int k) {
        int count = 0;
        Arrays.fill(numbers, true);

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (numbers[j]) {
                    numbers[j] = false;
                    count++;
                }

                if (count == k) {
                    return j;
                }
            }
        }

        return n;
    }

}
