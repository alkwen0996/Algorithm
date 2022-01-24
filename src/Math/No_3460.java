package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_3460 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(bufferedReader.readLine()); // 테스트케이스 개수

        final List<String> numbers = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            numbers.add(Integer.toBinaryString(input));
        }

        String result = solve(T, numbers);
        System.out.println(result);
    }

    private static String solve(final int t, final List<String> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (String number : numbers) {
            int count = 0;

            for (int j = number.length() - 1; j >= 0; j--) {
                if (number.charAt(j) == '1') {
                    stringBuilder.append(count).append(SPACE);
                }
                count++;
            }

        }

        return stringBuilder.toString();
    }
}
