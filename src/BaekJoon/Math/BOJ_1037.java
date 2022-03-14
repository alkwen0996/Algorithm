package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int count = Integer.parseInt(bufferedReader.readLine());

        final int[] divisors = new int[count];
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            divisors[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = solution(divisors);
        System.out.println(result);
    }

    private static int solution(final int[] divisors) {
        int max = Arrays.stream(divisors)
                .max()
                .getAsInt();

        int min = Arrays.stream(divisors)
                .min()
                .getAsInt();

        return max * min;
    }
}
