package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2775 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solve(k, n)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int solve(final int k, final int n) {
        if (k == 0) {
            return n;
        }

        if (n == 0) {
            return 0;
        }

        return solve(k - 1, n) + solve(k, n - 1);
    }
}
