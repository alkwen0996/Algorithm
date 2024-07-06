import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(cutStick(input));
    } // main

    private static int cutStick(final String input) {
        char[] letters = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        int stickCount = 0;
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];

            if (letter == '(') {
                stack.push(letter);
                continue;
            }

            if (letter == ')') {
                stack.pop();

                if (letters[i - 1] == '(') {
                    stickCount += stack.size();
                } else {
                    stickCount++;
                }
            }
        }

        return stickCount;
    }
} // class
