package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_17413 {
    private static final char LEFT_ARROW = '<';
    private static final char RIGHT_ARROW = '>';
    private static final char SPACE = ' ';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        char[] words = line.toCharArray();

        String result = solve(words);
        System.out.println(result);
    }

    private static String solve(final char[] words) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Stack<Character> stack = new Stack<>();

        boolean checkBracket = false;

        for (final char word : words) {
            if (word == LEFT_ARROW) {
                stringBuilder.append(reverseWord(stack));
                stringBuilder.append(word);
                checkBracket = true;
            } else if (word == RIGHT_ARROW) {
                stringBuilder.append(word);
                checkBracket = false;
            } else if (word == SPACE) {
                stringBuilder.append(reverseWord(stack));
                stringBuilder.append(word);
            } else {
                if (checkBracket) {
                    stringBuilder.append(word);
                } else {
                    stack.push(word);
                }
            }
        }

        stringBuilder.append(reverseWord(stack));

        return stringBuilder.toString();
    }

    private static String reverseWord(final Stack<Character> stack) {
        final StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }
}
