package Programmers.Level2;


public class No_12951 {
    private static final char SPACE = ' ';

    public static void main(String[] args) {
        String s = "for the last week";

        String result = solution(s);
        System.out.println(result);
    }

    private static String solution(final String s) {
        final StringBuilder stringBuilder = new StringBuilder();
        char[] wordCharacters = s.toCharArray();

        for (int i = 0; i < wordCharacters.length; i++) {
            if (i == 0) {
                stringBuilder.append(Character.toUpperCase(wordCharacters[i]));
                continue;
            }

            if (wordCharacters[i - 1] == SPACE) {
                stringBuilder.append(wordCharacters[i] = Character.toUpperCase(wordCharacters[i]));
            } else {
                stringBuilder.append(wordCharacters[i] = Character.toLowerCase(wordCharacters[i]));
            }
        }

        return stringBuilder.toString();
    }
}
