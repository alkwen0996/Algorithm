package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1316 {

    public static final int ALPHABET_COUNT = 26;
    public static final char CHAR_A = 'a';
    public static final int NUMBER_ONE = 1;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countLine = Integer.parseInt(bufferedReader.readLine());
        final List<String> words = new ArrayList<>();

        for (int i = 0; i < countLine; i++) {
            words.add(bufferedReader.readLine());
        }

        int result = solve(words);
        System.out.println(result);
    }

    private static int solve(final List<String> words) {
        int count = 0;
        for (String str : words) {
            if (checkGroupWord(str)) {
                count++;
            }
        }
        return count;
    }

    private static Boolean checkGroupWord(final String str) {
        final boolean[] alphabet = new boolean[ALPHABET_COUNT];
        final char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int index = str.charAt(i) - CHAR_A;
            if (alphabet[index] && chars[i] != chars[i - NUMBER_ONE]) {
                return false;
            }
            alphabet[index] = true;
        }
        return true;
    }
}
