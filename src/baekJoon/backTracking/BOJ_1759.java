package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

    private static final String NEW_LINE = "\n";

    private static String[] vowels = {"a", "e", "i", "o", "u"};
    private static String[] totalLetters;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int passwordCount = Integer.parseInt(stringTokenizer.nextToken());
        final int totalLettersCount = Integer.parseInt(stringTokenizer.nextToken());

        totalLetters = new String[totalLettersCount];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < totalLettersCount; i++) {
            totalLetters[i] = stringTokenizer.nextToken();
        }

        Arrays.sort(totalLetters);

        final StringBuilder stringBuilder = new StringBuilder();
        createPassword(passwordCount, stringBuilder, 0, "");
        System.out.println(stringBuilder);
    }

    private static void createPassword(final int passwordCount, final StringBuilder stringBuilder, final int index, final String password) {
        if (password.length() == passwordCount) {
            if (isPassword(password)) {
                stringBuilder.append(password).append(NEW_LINE);
            }

            return;
        }

        if (index >= totalLetters.length) {
            return;
        }

        createPassword(passwordCount, stringBuilder, index + 1, password + totalLetters[index]);
        createPassword(passwordCount, stringBuilder, index + 1, password);
    }

    private static boolean isPassword(final String password) {
        int count = 0;

        for (final String vowel : vowels) {
            if (password.contains(vowel)) {
                count++;
            }
        }

        return count >= 1 && (password.length() - count >= 2);
    }

}
