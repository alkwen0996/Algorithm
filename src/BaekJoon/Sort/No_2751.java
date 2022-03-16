package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2751 {
    public static final String NEW_LINE = "\n";
    public static final int ARRAY_SIZE = 2_000_001;
    public static final int ABSOLUTE_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final boolean[] numbers = new boolean[ARRAY_SIZE];

        while (N-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());
            numbers[number + ABSOLUTE_VALUE] = true;
        }

        String result = solve(numbers);
        System.out.println(result);
    }

    private static String solve(final boolean[] numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]) {
                stringBuilder.append(i - ABSOLUTE_VALUE).append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }
}
