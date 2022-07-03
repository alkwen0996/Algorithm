package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {

    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private static final char PLUS = '+';
    private static final char MINUS = '-';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String readLine = bufferedReader.readLine();

        System.out.println(createPostfixNotation(readLine));
    }

    private static StringBuilder createPostfixNotation(final String readLine) {
        final Stack<Character> stack = new Stack<>();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < readLine.length(); i++) {
            char data = readLine.charAt(i);

            if (Character.isUpperCase(data)) {
                stringBuilder.append(data);
                continue;
            }

            if (data == OPEN_BRACKET) {
                stack.push(data);
                continue;
            }

            if (data == CLOSE_BRACKET) {
                while (!stack.isEmpty() && stack.peek() != OPEN_BRACKET) {
                    stringBuilder.append(stack.pop());
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            while (!stack.isEmpty() && (operationPriority(stack.peek()) >= operationPriority(data))) {
                stringBuilder.append(stack.pop());
            }

            stack.push(data);
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder;
    }

    private static int operationPriority(final Character operation) {
        if (operation == MULTIPLICATION || operation == DIVISION) {
            return 2;
        } else if (operation == PLUS || operation == MINUS) {
            return 1;
        } else {
            return 0;
        }
    }

}

