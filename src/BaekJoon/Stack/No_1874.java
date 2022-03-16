package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_1874 {
    private static final String NEW_LINE = "\n";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        int start = 0;
        final Stack<Integer> stack = new Stack<>();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            final int inputNumber = Integer.parseInt(bufferedReader.readLine());
            System.out.println("inputNumber: " + inputNumber);

            if (inputNumber > start) {
                for (int j = start + 1; j <= inputNumber; j++) {
                    stack.push(j);
                    stringBuilder.append(PLUS).append(NEW_LINE);
                }

                start = inputNumber;
            } else if (stack.peek() != inputNumber) {
                stringBuilder.append(NO);
                break;
            }

            int popNumber = stack.pop();
            stringBuilder.append(MINUS).append(NEW_LINE);
        }

        if (stringBuilder.toString().contains(NO)) {
            System.out.println(NO);
        } else {
            System.out.println(stringBuilder);
        }
    }
}
