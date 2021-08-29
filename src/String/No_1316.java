package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1316 {
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
        final List<Character> containsChar = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            if (str.contains(Character.toString(i))) {
                containsChar.add(i);
            }
        }

        int firstCharLocation = 0, lastCharLocation = 0;
        for (Character character : containsChar) {
            firstCharLocation = str.indexOf(character);
            lastCharLocation = str.lastIndexOf(character);
            for (int i = firstCharLocation; i <= lastCharLocation; i++) {
                if (str.charAt(i) != character) {
                    return false;
                }
            }
        }

        return true;
    }
}
