package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int e = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        final int s = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        final int m = Integer.parseInt(stringTokenizer.nextToken()) - 1;

        int result = solution(e, s, m);
        System.out.println(result);
    }

    private static int solution(final int e, final int s, final int m) {
        int year = 0;

        while (year % 15 != e || year % 28 != s || year % 19 != m) {
            year++;
        }

        return year + 1;
    }
}
