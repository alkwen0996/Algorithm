package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_9012 {
    public static final String NEW_LINE = "\n";
    public static final String NO = "NO";
    public static final String YES = "YES";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append(NEW_LINE);
        }

        System.out.println(stringBuilder.toString());
    }

    private static String solve(final String inputData) {
        final char[] parentheses = inputData.toCharArray();
        final Stack<Character> checkVPS = new Stack<>();
        String result = NO;

        for (final char parenthesis : parentheses) {
            if (parenthesis == '(') {
                checkVPS.push(parenthesis);
            } else if (parenthesis == ')' && !checkVPS.isEmpty()) {
                // 가독성위해 imEmpty()따로 체크
                checkVPS.pop();
            } else {
                return NO;
            } // else 조건분기 간략화
        }

        if (checkVPS.isEmpty()) {
            result = YES;
        }
        return result;
    }
}
