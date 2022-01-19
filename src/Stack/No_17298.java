package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_17298 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        String result = solve(numbers);
        System.out.println(result);
    }

    private static String solve(final int[] numbers) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && (numbers[stack.peek()] < numbers[i])) {
                numbers[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        for (Integer number : numbers) {
            stringBuilder.append(number).append(SPACE);
        }

        return stringBuilder.toString();
    }
}
