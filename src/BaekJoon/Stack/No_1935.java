package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_1935 {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final String calculation = bufferedReader.readLine();
        final double[] operand = new double[n];

        for (int i = 0; i < n; i++) {
            operand[i] = Integer.parseInt(bufferedReader.readLine());
        }

        double result = solve(calculation, operand);
        System.out.printf("%.2f%n", result);
    }

    private static double solve(final String calculation, final double[] operand) {
        final Stack<Double> stack = new Stack<>();

        for (int i = 0; i < calculation.length(); i++) {
            if (Character.isUpperCase(calculation.charAt(i))) {
                int alphabetValue = (int) calculation.charAt(i) - 65;
                stack.push(operand[alphabetValue]);
            } else {
                double calculateValue = 0.00;

                Double pop1 = stack.pop();
                Double pop2 = stack.pop();

                if (calculation.charAt(i) == PLUS) {
                    calculateValue = pop2 + pop1;
                } else if (calculation.charAt(i) == MINUS) {
                    calculateValue = pop2 - pop1;
                } else if (calculation.charAt(i) == MULTIPLICATION) {
                    calculateValue = pop2 * pop1;
                } else if (calculation.charAt(i) == DIVISION) {
                    calculateValue = pop2 / pop1;
                }

                stack.push(calculateValue);
            }
        }

        return stack.pop();
    }

}
