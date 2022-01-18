package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_10799 {

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        int result = solve(line);
        System.out.println(result);
    }

    private static int solve(final String line) {
        int stickCount = 0;
        final Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == OPEN_BRACKET) {
                brackets.add(line.charAt(i));
                continue;
            }

            if (line.charAt(i) == CLOSE_BRACKET) {
                brackets.pop();

                if (line.charAt(i - 1) == OPEN_BRACKET) {
                    stickCount += brackets.size();
                } else {
                    stickCount++;
                }
            }
        }

        return stickCount;
    }
}
