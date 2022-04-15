package BaekJoon.Brute_Force.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    private static int[] sequence;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int s = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int index = 0;
        int sum = 0;
        countingSequence(n, s, index, sum);

        if (s == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static void countingSequence(final int n, final int s, final int index, final int sum) {
        if (index == n) {
            if (sum == s) {
                count++;
            }

            return;
        }

        countingSequence(n, s, index + 1, sum + sequence[index]);
        countingSequence(n, s, index + 1, sum);
    }

}
