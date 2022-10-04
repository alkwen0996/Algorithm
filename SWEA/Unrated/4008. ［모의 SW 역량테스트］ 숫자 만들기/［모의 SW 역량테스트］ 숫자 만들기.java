
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static final int OPERATION_TYPE_COUNT = 4;
    private static int numberCount, maximum, minimum;
    private static int[] operators, operand;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            numberCount = Integer.parseInt(bufferedReader.readLine());
            operators = new int[OPERATION_TYPE_COUNT];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < OPERATION_TYPE_COUNT; j++) {
                operators[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            operand = new int[numberCount];

            for (int j = 0; j < numberCount; j++) {
                operand[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            maximum = Integer.MIN_VALUE;
            minimum = Integer.MAX_VALUE;

            findMinimumResult(0, operand[0]);
            stringBuilder.append("#").append(i).append(" ").append((maximum - minimum)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void findMinimumResult(int depth, int result) {
        if (depth == numberCount - 1) {
            maximum = Math.max(maximum, result);
            minimum = Math.min(minimum, result);

            return;
        }

        for (int i = 0; i < OPERATION_TYPE_COUNT; i++) {
            if (operators[i] == 0)
                continue;

            operators[i]--;

            switch (i) {
                case 0:
                    findMinimumResult(depth + 1, result + operand[depth + 1]);
                    break;
                case 1:
                    findMinimumResult(depth + 1, result - operand[depth + 1]);
                    break;
                case 2:
                    findMinimumResult(depth + 1, result * operand[depth + 1]);
                    break;
                case 3:
                    findMinimumResult(depth + 1, result / operand[depth + 1]);
                    break;
            }

            operators[i]++;
        }

    }

}

