package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_9613 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int n = Integer.parseInt(stringTokenizer.nextToken());

            final List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringBuilder.append(solve(numbers)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static long solve(final List<Integer> numbers) {
        long gcd = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int first = numbers.get(i);
                int second = numbers.get(j);

                gcd += gcd(first, second);
            }
        }

        return gcd;
    }

    private static int gcd(int first, int second) {
        while (second != 0) {
            int r = first % second;
            first = second;
            second = r;
        }

        return first;
    }
}
