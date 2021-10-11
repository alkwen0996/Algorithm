package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_17413 {
    private static final String LEFT_ARROW = "<";
    private static final String RIGHT_ARROW = ">";
    private static final String BLANK = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String words = bufferedReader.readLine();

        String result = solve(words);
        System.out.println(result);
    }

    private static String solve(final String words) {
        char[] wordsCharacters = words.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<String> reverseWord = new ArrayDeque<>();

        boolean arrowCheck = false;
        int wordsLength = wordsCharacters.length;
        for (int i = 0; i < wordsLength; i++) {
            String wordCharacter = String.valueOf(wordsCharacters[i]);
            if (wordCharacter.equals(LEFT_ARROW)) {
                stringBuilder.append(extractReverseWord(reverseWord));
                stringBuilder.append(wordCharacter);
                arrowCheck = true;
            } else if (wordCharacter.equals(RIGHT_ARROW)) {
                arrowCheck = false;
                stringBuilder.append(wordCharacter);
            } else if (wordCharacter.equals(BLANK)) {
                stringBuilder.append(extractReverseWord(reverseWord));
                stringBuilder.append(wordCharacter);
            } else {
                if (arrowCheck) {
                    stringBuilder.append(wordCharacter);
                } else {
                    reverseWord.push(wordCharacter);
                }
            }
        }
        stringBuilder.append(extractReverseWord(reverseWord));
        return stringBuilder.toString();
    }

    private static String extractReverseWord(final Deque<String> reverseWord) {
        final StringBuilder stringBuilder = new StringBuilder();
        while (!reverseWord.isEmpty()) {
            stringBuilder.append(reverseWord.pop());
        }
        return stringBuilder.toString();
    }
}
