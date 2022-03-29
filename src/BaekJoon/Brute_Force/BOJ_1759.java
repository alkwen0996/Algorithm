package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int targetLetterCount = Integer.parseInt(stringTokenizer.nextToken());

        final int totalLetterCount = Integer.parseInt(stringTokenizer.nextToken());
        String[] totalLetters = new String[totalLetterCount];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < totalLetterCount; i++) {
            totalLetters[i] = stringTokenizer.nextToken();
        }

        Arrays.sort(totalLetters);

        int index = 0;
        String password = "";

        findPassword(targetLetterCount, totalLetters, password, index);
        System.out.println(stringBuilder);
    }

    private static void findPassword(final int targetLetterCount, final String[] totalLetters, final String password, final int index) {
        if (password.length() == targetLetterCount) {
            if (checkContainsVowels(password)) {
                stringBuilder.append(password).append(NEW_LINE);
            }

            return;
        }

        if (index >= totalLetters.length) {
            return;
        }

        findPassword(targetLetterCount, totalLetters, password + totalLetters[index], index + 1);
        findPassword(targetLetterCount, totalLetters, password, index + 1);
    }

    private static boolean checkContainsVowels(final String password) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (final char useLetter : password.toCharArray()) {
            if (useLetter == 'a' || useLetter == 'e' || useLetter == 'i' || useLetter == 'o' || useLetter == 'u') {
                vowelCount += 1;
                continue;
            }

            consonantCount += 1;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

}
