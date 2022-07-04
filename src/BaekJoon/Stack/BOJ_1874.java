package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_1874 {

    private static final String MINUS = "-";
    private static final String NEW_LINE = "\n";
    private static final String PLUS = "+";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfInputData = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> inputNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfInputData; i++) {
            inputNumbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        System.out.println(solve(inputNumbers));
    }

    private static String solve(final List<Integer> inputNumbers) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Stack<Integer> stack = new Stack<>();

        int startNumber = 0;
        boolean check = false;

        for (int inputNumber : inputNumbers) {
            if (inputNumber > startNumber) {
                for (int j = startNumber + 1; j <= inputNumber; j++) {
                    stack.push(j);
                    stringBuilder.append(PLUS).append(NEW_LINE);
                }

                startNumber = inputNumber;
            }else if (stack.peek() != inputNumber) {
                check = true;
                break;
            }

            stack.pop();
            stringBuilder.append(MINUS).append(NEW_LINE);
        }

        if(check){
            return NO;
        }

        return stringBuilder.toString();
    }

}
