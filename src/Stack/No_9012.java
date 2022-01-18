package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9012 {
    private static final char CLOSE_ROUND_BRACKET = ')';
    private static final String NEW_LINE = "\n";
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final char OPEN_ROUND_BRACKET = '(';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static String solve(final String line) {
        final Stack<Character> checkVPS = new Stack<>();
        String result = NO;

        for (int j = 0; j < line.length(); j++) {
            char lineCharacter = line.charAt(j);

            if (lineCharacter == OPEN_ROUND_BRACKET) {
                checkVPS.add(lineCharacter);
            } else if (lineCharacter == CLOSE_ROUND_BRACKET && !checkVPS.isEmpty()) {
                checkVPS.pop();
            } else {
                return result;
            }
        }

        if (checkVPS.isEmpty()) {
            result = YES;
        }

        return result;
    }
}
