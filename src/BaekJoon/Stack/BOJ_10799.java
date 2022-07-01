package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = '(';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String inputData = bufferedReader.readLine();

        System.out.println(solve(inputData));
        ;
    }

    private static int solve(final String inputData) {
        int numberOfStick = 0;
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputData.length(); i++) {
            char bracket = inputData.charAt(i);

            if (bracket == OPEN_BRACKET) {
                stack.push(bracket);
                continue;
            }

            stack.pop();

            if (inputData.charAt(i - 1) == CLOSE_BRACKET) {
                numberOfStick += stack.size();
                continue;
            }

            numberOfStick++;
        }

        return numberOfStick;
    }
}
