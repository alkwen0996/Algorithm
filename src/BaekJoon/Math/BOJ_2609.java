package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int number1 = Integer.parseInt(stringTokenizer.nextToken());
        int number2 = Integer.parseInt(stringTokenizer.nextToken());

        String result = solution(number1, number2);
        System.out.println(result);
    }

    private static String solution(final int number1, final int number2) {
        int max = Math.max(number1, number2);
        int min = Math.min(number1, number2);

        int gcd = gcd(max, min);
        int lcd = (max * min) / gcd;

        return gcd + NEW_LINE + lcd;
    }

    private static int gcd(final int max, final int min) {
        if (max % min == 0) {
            return min;
        }

        return gcd(min, max % min);
    }
}
