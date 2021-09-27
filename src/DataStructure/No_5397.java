package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_5397 {

    public static final String DASH = "-";
    public static final String LEFT_INEQUALITY_SIGN = "<";
    public static final String RIGHT_INEQUALITY_SIGN = ">";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append("\n");
        }
    }

    private static String solve(final String readLine) {
        String result = readLine;
        if (readLine.contains(RIGHT_INEQUALITY_SIGN) || readLine.contains(LEFT_INEQUALITY_SIGN) || readLine.contains(DASH)) {
            result = deleteSign(readLine);
        }

        return result;
    }

    private static String deleteSign(final String readLine) {
        final Deque<String> inputPasswords = new ArrayDeque<>();
        char[] inputDataCharters = readLine.toCharArray();
        final List<String> result = new LinkedList<>();

        for (final char inputDataCharter : inputDataCharters) {
            result.add(String.valueOf(inputDataCharter));
        }

        for (int i = 0; i < result.size(); i++){

        }

        System.out.println(inputPasswords.toString());

        return null;
    }
}
