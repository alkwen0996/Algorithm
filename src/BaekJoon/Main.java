package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String NEW_LINE = "\n";

    private static String[] totalLetters;
    private static boolean[] checkUsingLetters;
    private static int targetLetterCount;
    private static String[] useLetters;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        targetLetterCount = Integer.parseInt(stringTokenizer.nextToken());
        useLetters = new String[targetLetterCount];

        final int totalLetterCount = Integer.parseInt(stringTokenizer.nextToken());
        totalLetters = new String[totalLetterCount];
        checkUsingLetters = new boolean[totalLetterCount];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < totalLetterCount; i++) {
            totalLetters[i] = stringTokenizer.nextToken();
        }

        Arrays.sort(totalLetters);

        int index = 0;
        int start = 0;

        findPassword(index, start);
        System.out.println(stringBuilder);
    }

    private static void findPassword(final int index, int start) {
        if (index == targetLetterCount) {
            if (checkContainsVowels()) {
                for (final String useLetter : useLetters) {
                    stringBuilder.append(useLetter);
                }

                stringBuilder.append(NEW_LINE);
            }

            return;
        }

        for (int i = start; i < totalLetters.length; i++) {
            if (checkUsingLetters[i]) {
                continue;
            }

            checkUsingLetters[i] = true;
            useLetters[index] = totalLetters[i];
            start = i;
            findPassword(index + 1, start);
            checkUsingLetters[i] = false;
        }
    }

    private static boolean checkContainsVowels() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (final String useLetter : useLetters) {
            if (useLetter.equals("a") || useLetter.equals("e") || useLetter.equals("i") || useLetter.equals("o") || useLetter.equals("u")) {
                vowelCount += 1;
                continue;
            }

            consonantCount += 1;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

}
