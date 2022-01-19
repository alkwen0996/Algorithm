package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_10808 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        final Map<Character, Integer> alphabets = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            alphabets.put(((char) (97 + i)), 0);
        }

        for (int i = 0; i < word.length(); i++) {
            alphabets.put(word.charAt(i), alphabets.get(word.charAt(i)) + 1);
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (char character:alphabets.keySet()) {
            stringBuilder.append(alphabets.get(character)).append(SPACE);
        }

        System.out.println(stringBuilder);
    }
}
