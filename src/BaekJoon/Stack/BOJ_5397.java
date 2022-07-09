package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ_5397 {

    private static final String NEW_LINE = "\n";
    private static final char DELETE_SYMBOL = '-';
    private static final char LEFT_MOVE_SYMBOL = '<';
    private static final char RIGHT_MOVE_SYMBOL = '>';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final List<String> inputValues = new ArrayList<>();

        for (int i = 0; i < numberOfTestCase; i++) {
            inputValues.add(bufferedReader.readLine());
        }

        System.out.println(solve(inputValues));
    }

    private static StringBuilder solve(final List<String> inputValues) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (String inputValue : inputValues) {
            stringBuilder.append(getPassword(inputValue)).append(NEW_LINE);
        }

        return stringBuilder;
    }

    private static StringBuilder getPassword(final String inputValue) {
        final StringBuilder stringBuilder = new StringBuilder();

        final Deque<Character> right = new ArrayDeque<>();
        final Deque<Character> left = new ArrayDeque<>();

        for (int i = 0; i < inputValue.length(); i++) {
            final char character = inputValue.charAt(i);

            if(!left.isEmpty()){
                if (character == LEFT_MOVE_SYMBOL) {
                    right.push(left.pop());
                    continue;
                }

                if (character == DELETE_SYMBOL) {
                    left.pop();
                    continue;
                }
            }

            if (character == RIGHT_MOVE_SYMBOL) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
                continue;
            }

            if (Character.isAlphabetic(character) || Character.isDigit(character)) {
                left.push(character);
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            stringBuilder.append(right.pop());
        }

        return stringBuilder;
    }

}
