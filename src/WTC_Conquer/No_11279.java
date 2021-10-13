package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_11279 {
    public static final String NEW_LINE = "\n";
    public static final int ZERO = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int calculationCount = Integer.parseInt(bufferedReader.readLine());

        final Queue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < calculationCount; i++) {
            final int number = Integer.parseInt(bufferedReader.readLine());
            if (number == ZERO) {
                if (numbers.isEmpty()) {
                    stringBuilder.append(ZERO).append(NEW_LINE);
                } else {
                    stringBuilder.append(numbers.poll()).append(NEW_LINE);
                }
            } else {
                numbers.add(number);
            }
        }

        System.out.println(stringBuilder.toString());

    }
}
