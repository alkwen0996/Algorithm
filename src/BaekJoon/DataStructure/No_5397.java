package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_5397 {
    public static final char RIGHT_ARROW = '>';
    public static final char LEFT_ARROW = '<';
    public static final char DASH = '-';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static String solve(final String readLine) {
        if (readLine.contains(String.valueOf(RIGHT_ARROW)) || readLine.contains(String.valueOf(LEFT_ARROW)) || readLine.contains(String.valueOf(DASH))) {
            return readLine;
        }

        final char[] originalPasswordCharacters = readLine.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<Character> outputPassword = new ArrayDeque<>();

        final int originalPasswordLength = originalPasswordCharacters.length;
        for (int i = 0; i < originalPasswordLength; i++) {
            char originalPasswordCharacter = originalPasswordCharacters[i];
            
        }

        return stringBuilder.toString();
    }
}
