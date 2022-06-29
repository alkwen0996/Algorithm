package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

    private static final String NEW_LINE = "\n";
    private static final char OPEN_BRACKET = '(';
    private static final String NO = "NO";
    private static final String YES = "YES";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            final String inputData = bufferedReader.readLine();

            stringBuilder.append(checkVPS(inputData)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static String checkVPS(final String inputData) {
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputData.length(); i++) {
            char bracket = inputData.charAt(i);

            if(bracket == OPEN_BRACKET){
                stack.push(bracket);
                continue;
            }

            if(stack.isEmpty()){
                return NO;
            }

            stack.pop();
        }

        if(stack.size() > 0){
            return NO;
        }

        return YES;
    }

}
