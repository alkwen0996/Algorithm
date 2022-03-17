package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int e = Integer.parseInt(stringTokenizer.nextToken());
        final int s = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        int result = solution(e, s, m);
        System.out.println(result);
    }

    private static int solution(final int e, final int s, final int m) {
        int year = 1;

        int countE = 1;
        int countS = 1;
        int countM = 1;

        while (countE != e || countS != s || countM != m) {
            if (countE == 15) {
                countE = 0;
            }

            if (countS == 28) {
                countS = 0;
            }

            if (countM == 19) {
                countM = 0;
            }

            countE++;
            countS++;
            countM++;
            year++;
        }

        return year;
    }
}
