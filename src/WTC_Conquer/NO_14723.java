package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이산수학과제
public class NO_14723 {
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solve(N));
    }

    private static String solve(final int n) {
        final StringBuilder stringBuilder = new StringBuilder();

        int start = 1;
        if (n == start) {
            return stringBuilder.append(1).append(SPACE).append(1).toString();
        }

        int index = 2;
        while (start < n) {
            start += index;
            index++;
        }

        int b = index - 1;
        int a = 1;

        while (start != n) {
            start--;
            a++;
            b--;
        }

        return stringBuilder.append(a).append(SPACE).append(b).toString();
    }
}
