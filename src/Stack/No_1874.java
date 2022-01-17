package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class No_1874 {
    private static final String NEW_LINE = "\n";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final int[] inputNumberOrder = new int[n];
        final int[] resultOrder = new int[n];

        for (int i = 0; i < n; i++) {
            int inputNUmber = Integer.parseInt(bufferedReader.readLine());

            inputNumberOrder[i] = inputNUmber;
            resultOrder[i] = inputNUmber;
        }

        String resultSequence = solve(inputNumberOrder, resultOrder);
        System.out.println(resultSequence);
    }

    private static String solve(final int[] inputNumbers, final int[] resultOrder) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Stack<Integer> sequence = new Stack<>();

        Arrays.sort(inputNumbers);
        int index = 0;

        for (final int inputNumber : inputNumbers) {
            sequence.add(inputNumber);
            stringBuilder.append(PLUS).append(NEW_LINE);

            int count = 0;
            int size = sequence.size();

            while (!sequence.isEmpty() && sequence.contains(resultOrder[index])) {
                int popNumber = sequence.pop();

                if (popNumber == resultOrder[index]) {
                    stringBuilder.append(MINUS).append(NEW_LINE);
                    index++;
                } else {
                    sequence.add(popNumber);
                }

                if (count > size) {
                    break;
                }

                count++;
            }

        }

        if (sequence.size() > 0) {
            return NO;
        }

        return stringBuilder.toString();
    }
}
