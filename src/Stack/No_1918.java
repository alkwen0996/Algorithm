package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_1918 {

    private static final char OPEN_ROUND_BRACKET = '(';
    private static final char CLOSE_ROUND_BRACKET = ')';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char MINUS = '-';
    private static final char PLUS = '+';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String calculation = bufferedReader.readLine();

        String result = solve(calculation);
        System.out.println(result);
    }

    private static String solve(final String line) {
        final Stack<Character> operations = new Stack<>();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (Character.isUpperCase(line.charAt(i))) {
                stringBuilder.append(line.charAt(i));
            } else {
                if (line.charAt(i) == OPEN_ROUND_BRACKET) {
                    operations.push(line.charAt(i));
                } else if (line.charAt(i) == CLOSE_ROUND_BRACKET) {
                    while (!operations.isEmpty() && operations.peek() != OPEN_ROUND_BRACKET) {
                        stringBuilder.append(operations.pop());
                    }
                    if (!operations.isEmpty()) {
                        operations.pop();
                    }
                } else {
                    while (!(operations.isEmpty()) && (priority(operations.peek()) >= priority(line.charAt(i)))) {
                        stringBuilder.append(operations.pop());
                    }
                    operations.push(line.charAt(i));
                }
            }
        }

        while (!operations.isEmpty()) {
            stringBuilder.append(operations.pop());
        }

        return stringBuilder.toString();
    }

    private static int priority(final Character operation) {
        if (operation == MULTIPLICATION || operation == DIVISION) {
            return 2;
        } else if (operation == PLUS || operation == MINUS) {
            return 1;
        } else {
            return 0;
        }
    }
}
