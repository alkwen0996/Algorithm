package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2501 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int K = Integer.parseInt(stringTokenizer.nextToken());

        int result = solve(N, K);
        System.out.println(result);
    }

    private static int solve(final int n, final int k) {
        int divisor = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }

            if (count == k) {
                divisor = i;
                break;
            }
        }

        return divisor;
    }
}
