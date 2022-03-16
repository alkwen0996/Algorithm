package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_23251 {
    public static final int TWENTY_THREE = 23;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        final int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            stringBuilder.append(solve(Integer.parseInt(bufferedReader.readLine()))).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solve(final int k) {
        return k * TWENTY_THREE;
    }
}
