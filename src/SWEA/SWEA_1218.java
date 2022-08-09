package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA_1218 {
    private static final String SPACE = " ";
    private static final String SHARP = "#";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = 10;

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int bracketsCount = Integer.parseInt(bufferedReader.readLine());
            String brackets = bufferedReader.readLine();

            stringBuilder.append(SHARP).append(i + 1).append(SPACE).append(isPair(brackets)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int isPair(final String brackets) {
        final Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);

            if (bracket == '(' || bracket == '[' || bracket == '{' || bracket == '<') {
                stack.push(bracket);
                continue;
            }

            if (!stack.isEmpty()) {
                char pop = stack.pop();

                if (bracket == ')' && pop != '(') {
                    return 0;
                }

                if (bracket == ']' && pop != '[') {
                    return 0;
                }

                if (bracket == '}' && pop != '{') {
                    return 0;
                }

                if (bracket == '>' && pop != '<') {
                    return 0;
                }
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }

}
