package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_10773 {
    public static final int ZERO = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int lineCount = Integer.parseInt(bufferedReader.readLine());
        final Deque<Integer> sumNumbers = new ArrayDeque<>();

        for (int i = 0; i < lineCount; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == ZERO) {
                sumNumbers.pop();
            } else {
                sumNumbers.push(number);
            }
        }

        int result = 0;
        while (!sumNumbers.isEmpty()) {
            result += sumNumbers.pop();
        }
        System.out.println(result);

    }
}
