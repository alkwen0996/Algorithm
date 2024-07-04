import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static final String EOF = ".";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder stringBuilder = new StringBuilder();

        while (!(input = bufferedReader.readLine()).equals(EOF)) {
            char[] charArray = input.trim().toCharArray();
            stringBuilder.append(checkPair(charArray)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    } // main

    private static String checkPair(final char[] charArray) {
        Stack<Character> stack = new Stack<>();

        for (char letter : charArray) {
            if (letter == '.') {
                break;
            }

            if (letter == '(' || letter == '[') {
                stack.push(letter);
                continue;
            }

            if (letter == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }

                stack.pop();
            }

            if (letter == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }

                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        }

        return "no";
    }
} // class
