package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[n + 1];

        int index = 0;
        String permutation = "";
        findAllPermutation(n, index, permutation);

        System.out.println(stringBuilder);
    }

    private static void findAllPermutation(final int n, final int index, final String permutation) {
        if (index == n) {
            stringBuilder.append(permutation).append(NEW_LINE);

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            findAllPermutation(n, index + 1, permutation + i + SPACE);
            visited[i] = false;
        }

    }

}
