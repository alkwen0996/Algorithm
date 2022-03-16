package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10250 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputTestCase = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputTestCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringBuilder.append(solve(stringTokenizer)).append('\n');
        }
        System.out.println(stringBuilder);
    }

    private static int solve(final StringTokenizer stringTokenizer) {
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int x = (N / H) + 1;
        int y = N % H;

        if (N % H == 0) {
            x = N / H;
            y = H;
        }

        return (y * 100 + x);
    }
}
