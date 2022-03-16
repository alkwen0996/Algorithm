package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11655 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String line = bufferedReader.readLine();

        String result = solve(line);
        System.out.println(result);
    }

    private static String solve(final String line) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);

            if (Character.isUpperCase(letter)) {
                if (letter + 13 > 90) {
                    stringBuilder.append((char) (letter + 13 - 26));
                } else {
                    stringBuilder.append((char) (letter + 13));
                }
            } else if (Character.isLowerCase(letter)) {
                if (letter + 13 > 122) {
                    stringBuilder.append((char) (letter + 13 - 26));
                } else {
                    stringBuilder.append((char) (letter + 13));
                }
            } else {
                stringBuilder.append(letter);
            }
        }

        return stringBuilder.toString();
    }
}
