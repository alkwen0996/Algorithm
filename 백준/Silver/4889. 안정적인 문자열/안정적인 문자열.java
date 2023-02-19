import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static final String SPACE = " ";
    public static final String DOT = ".";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();

        int index = 1;
        String input;
        while (!(input = bufferedReader.readLine()).contains("-")) {
            char[] brackets = input.toCharArray();

            stringBuilder.append(index)
                    .append(DOT)
                    .append(SPACE)
                    .append(changeBrackets(brackets))
                    .append(NEW_LINE);
            index++;
        }

        System.out.println(stringBuilder);
    }

    private static int changeBrackets(final char[] brackets) {
        final Deque<Character> deque = new ArrayDeque<>();
        int changeBracketCount = 0;

        for (final char bracket : brackets) {
//            System.out.println("남은 괄호: " + deque.toString());
            if (bracket == '}') {
                if (deque.isEmpty()) {
                    deque.push('{');
                    changeBracketCount++;
                } else {
                    deque.pop();
                }
            } else {
                deque.push(bracket);
            }
        }

//        System.out.println("남은 괄호 개수: " + deque.size());

        if (!deque.isEmpty()) {
            changeBracketCount += deque.size() / 2;
        }

        return changeBracketCount;
    }

}

