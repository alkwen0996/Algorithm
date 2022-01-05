package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2869 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        final int v = Integer.parseInt(stringTokenizer.nextToken());

        int result = solve(a, b, v);
        System.out.println(result);
    }

    private static int solve(final int a, final int b, final int v) {
        int dayCount = (v - b) / (a - b);

        if ((v - b) % (a - b) != 0) {
            dayCount++;
        }

        return dayCount;
    }
}
