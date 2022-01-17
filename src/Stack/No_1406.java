package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_1406 {
    private static final String MOVE_RIGHT = "D";
    private static final String MOVE_LEFT = "L";
    private static final String REMOVE_DATA = "B";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String sentence = bufferedReader.readLine();

        final int m = Integer.parseInt(bufferedReader.readLine());

        final Stack<String> leftStack = new Stack<>();
        final Stack<String> rightStack = new Stack<>();

        for (int i = 0; i < sentence.length(); i++) {
            leftStack.add(String.valueOf(sentence.charAt(i)));
        }

        for (int i = 0; i < m; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();

            switch (order) {
                case MOVE_LEFT:
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case MOVE_RIGHT:
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case REMOVE_DATA:
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                default:
                    String data = stringTokenizer.nextToken();
                    leftStack.push(data);
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        final StringBuilder stringBuilder = new StringBuilder();

        while (!rightStack.isEmpty()) {
            stringBuilder.append(rightStack.pop());
        }

        System.out.println(stringBuilder);
    }
}
