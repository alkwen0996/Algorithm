
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static final String NEW_LINE = "\n";
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        int number;

        for (int i = 0; i < testCaseCount; i++) {
            number = Integer.parseInt(bufferedReader.readLine());
            createZero(number, 1, 1, 1, 0, "1");
            stringBuilder.append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static void createZero(final int range, final int depth, final int number, final int sign, final int sum, final String expression) {
        if (depth == range) {
            int result = sum + (number * sign);

            if (result == 0) {
                stringBuilder.append(expression).append(NEW_LINE);
            }

            return;
        }

        createZero(range, depth + 1, number * 10 + (depth + 1), sign, sum, expression + " " + (depth + 1));
        createZero(range, depth + 1, depth + 1, 1, sum + (number * sign), expression + "+" + (depth + 1));
        createZero(range, depth + 1, depth + 1, -1, sum + (number * sign), expression + "-" + (depth + 1));
    }

}
