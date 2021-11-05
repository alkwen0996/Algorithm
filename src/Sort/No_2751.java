package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2751 {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> numbers = new ArrayList<>();
        int N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solve(numbers);
        System.out.println(result);
    }

    private static String solve(final List<Integer> numbers) {
        final StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(numbers);
        for (Integer number : numbers) {
            stringBuilder.append(number).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
