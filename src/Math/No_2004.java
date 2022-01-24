package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2004 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final long n = Integer.parseInt(stringTokenizer.nextToken());
        final long m = Integer.parseInt(stringTokenizer.nextToken());

        int twoCount = countTwo(n) - countTwo(n - m) - countTwo(m);
        int fiveCount = countFive(n) - countFive(n - m) - countFive(m);

        System.out.println(Math.min(twoCount, fiveCount));
    }

    private static int countFive(long number) {
        int count = 0;

        while (number >= 5) {
            count += number / 5;
            number /= 5;
        }

        return count;
    }

    private static int countTwo(long number) {
        int count = 0;

        while (number >= 2) {
            count += number / 2;
            number /= 2;
        }

        return count;
    }
}
