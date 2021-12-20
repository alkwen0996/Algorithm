package WTC_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_03 {
    public static final char BLANK = ' ';
    public static final int ALPHABET_COUNT = 26;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String word = bufferedReader.readLine();

        System.out.println(solve(word));
    }

    private static StringBuilder solve(final String word) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Map<String, String> alphabetMatching = new HashMap<>();
        final char[] wordCharacters = word.toCharArray();

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            alphabetMatching.put(Character.toString((char) (65 + i)), Character.toString((char) (90 - i)));
        }

        for (char wordCharacter : wordCharacters) {
            String matchAlphabet = alphabetMatching.get(Character.toString(Character.toUpperCase(wordCharacter)));

            if (matchAlphabet == null) {
                stringBuilder.append(wordCharacter);
            }else{
                boolean lowerCaseCheck = Character.isLowerCase(wordCharacter);

                if (lowerCaseCheck) {
                    matchAlphabet = alphabetMatching.get(Character.toString(Character.toUpperCase(wordCharacter))).toLowerCase();
                }

                stringBuilder.append(matchAlphabet);
            }
        }

        return stringBuilder;
    }
}
