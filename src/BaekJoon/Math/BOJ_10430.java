package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10430 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        final int c = Integer.parseInt(stringTokenizer.nextToken());

        String result = solution(a, b, c);
        System.out.println(result);
    }

    private static String solution(final int a, final int b, final int c) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append((a + b) % c).append(NEW_LINE);
        stringBuilder.append(((a % c) + (b % c)) % c).append(NEW_LINE);
        stringBuilder.append((a * b) % c).append(NEW_LINE);
        stringBuilder.append(((a % c) * (b % c)) % c).append(NEW_LINE);

        return stringBuilder.toString();
    }
}
