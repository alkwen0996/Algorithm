package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_10799 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bufferedReader.readLine();

        final Deque<Character> roundBrackets = new ArrayDeque<>();

        int result = solve(inputLine, roundBrackets);
        System.out.println(result);
    }

    private static int solve(final String inputLine, final Deque<Character> roundBrackets) {
        int result = 0;

        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == '(') {
                roundBrackets.push(inputLine.charAt(i));
            }

            if (inputLine.charAt(i) == ')') {
                roundBrackets.pop();

                if (inputLine.charAt(i - 1) == '(') {
                    result += roundBrackets.size();
                } else {
                    result++;
                }
            }

        }

        return result;
    }
}
