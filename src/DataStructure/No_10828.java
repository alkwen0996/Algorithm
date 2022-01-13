package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_10828 {
    private static final String PUSH = "push";
    private static final String TOP = "top";
    private static final String SIZE = "size";
    private static final String POP = "pop";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final Stack<Integer> stack = new Stack<>();

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();

            switch (order) {
                case PUSH:
                    int data = Integer.parseInt(stringTokenizer.nextToken());
                    stack.add(data);
                    break;
                case TOP:
                    if (stack.isEmpty()) {
                        stringBuilder.append(-1).append(NEW_LINE);
                    } else {
                        stringBuilder.append(stack.peek()).append(NEW_LINE);
                    }
                    break;
                case SIZE:
                    stringBuilder.append(stack.size()).append(NEW_LINE);
                    break;
                case POP:
                    if (stack.isEmpty()) {
                        stringBuilder.append(-1).append(NEW_LINE);
                    } else {
                        stringBuilder.append(stack.pop()).append(NEW_LINE);
                    }
                    break;
                default:
                    if (stack.isEmpty()) {
                        stringBuilder.append(1).append(NEW_LINE);
                    } else {
                        stringBuilder.append(0).append(NEW_LINE);
                    }
                    break;
            }
        }

        System.out.println(stringBuilder);
    }
}
