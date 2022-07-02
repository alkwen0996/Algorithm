package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int numberOftestCase = Integer.parseInt(bufferedReader.readLine());
        final List<String> inputLines = new ArrayList<>();

        for (int i = 0; i < numberOftestCase; i++) {
            inputLines.add(bufferedReader.readLine());
        }

        System.out.println(solve(inputLines));
    }

    private static int solve(final List<String> inputLines) {
        int goodWords = 0;

        for (String inputLine : inputLines) {
            if (checkGoodWords(inputLine)) {
                goodWords++;
            }
        }

        return goodWords;
    }

    private static boolean checkGoodWords(final String inputLine) {
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputLine.length(); i++) {
            char alphabet = inputLine.charAt(i);

            if (!stack.isEmpty() && stack.peek() == alphabet) {
                stack.pop();
                continue;
            }

            stack.push(alphabet);
        }

        return stack.size() == 0;
    }

}
