package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_11576 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int futureUsingNumberType = Integer.parseInt(stringTokenizer.nextToken());
        final int jungUsingNumberType = Integer.parseInt(stringTokenizer.nextToken());

        final int numberOfDigit = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numberOfDigit; i++) {
            stack.push(Integer.parseInt(stringTokenizer.nextToken()));
        }

        String result = solve(futureUsingNumberType, jungUsingNumberType, numberOfDigit, stack);
        System.out.println(result);
    }

    private static String solve(final int futureUsingNumberType, final int jungUsingNumberType, final int numberOfDigit, final Stack<Integer> stack) {
        int decimalNumber = 0;

        for (int i = 0; i < numberOfDigit; i++) {
            decimalNumber += (stack.pop() * Math.pow(futureUsingNumberType, i));
        }

        final Stack<Integer> decimalTypeToJungType = new Stack<>();

        while (decimalNumber != 0) {
            decimalTypeToJungType.push(decimalNumber % jungUsingNumberType);
            decimalNumber = decimalNumber / jungUsingNumberType;
        }

        final StringBuilder stringBuilder = new StringBuilder();

        while (!decimalTypeToJungType.isEmpty()) {
            int junTypeNumberOfDigit = decimalTypeToJungType.pop();
            stringBuilder.append(junTypeNumberOfDigit).append(SPACE);
        }

        return stringBuilder.toString();
    }
}
