package Programmers.Level2;

import java.util.Stack;

public class Prg_12899 {
    private static final String FOUR = "4";

    public static void main(String[] args) {
        final int n = 9;

        String result = solve(n);
        System.out.println(result);
    }

    private static String solve(final int n) {
        final Stack<String> stack = new Stack<>();
        int number = n;

        while (number > 0) {
            int remain = number % 3;
            number = number / 3;

            if (remain == 0) {
                stack.push(FOUR);
                number--;
            } else {
                stack.push(String.valueOf(remain));
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }
}
