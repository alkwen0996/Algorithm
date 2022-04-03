package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {
    private static final boolean[] visited = new boolean[10];
    private static final List<String> numbers = new ArrayList<>();

    private static final String LEFT_INEQUALITY_SIGN = ">";
    private static final String RIGHT_INEQUALITY_SIGN = "<";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int inequalitySignCount = Integer.parseInt(bufferedReader.readLine());

        final List<String> inequalitySings = new ArrayList<>();
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < inequalitySignCount; i++) {
            inequalitySings.add(stringTokenizer.nextToken());
        }

        int index = 0;
        String number = "";
        createNumber(inequalitySings, inequalitySignCount, index, number);

        Collections.sort(numbers);
        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));
    }

    private static void createNumber(final List<String> inequalitySings, final int inequalitySignCount, final int index, final String number) {
        if (index == inequalitySignCount + 1) {
            numbers.add(number);

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }

            if (index == 0 || checkInequalitySign(Character.getNumericValue(number.charAt(index - 1)), i, inequalitySings.get(index - 1))) {
                visited[i] = true;
                createNumber(inequalitySings, inequalitySignCount, index + 1, number + i);
                visited[i] = false;
            }
        }

    }

    private static boolean checkInequalitySign(final int firstNumber, final int secondNumber, final String inequalitySign) {
        if (inequalitySign.equals(LEFT_INEQUALITY_SIGN)) {
            return firstNumber > secondNumber;
        } else if (inequalitySign.equals(RIGHT_INEQUALITY_SIGN)) {
            return firstNumber < secondNumber;
        }

        return false;
    }
}
