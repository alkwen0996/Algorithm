package Programmers.Level2;

import java.util.Arrays;

public class Prg_42746 {
    private static final String ZERO = "0";
    private static final String DELIMITER = "";

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        String result = solution(numbers);
        System.out.println(result);
    }

    private static String solution(final int[] numbers) {
        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, (stringNumber1, stringNumber2) -> (stringNumber2 + stringNumber1).compareTo(stringNumber1 + stringNumber2));

        if (stringNumbers[0].equals(ZERO)) {
            return ZERO;
        }

        return String.join(DELIMITER, stringNumbers);
    }
}
