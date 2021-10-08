package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_17413 {
    public static final String LEFT_ARROW = "<";
    public static final String RIGHT_ARROW = ">";
    public static final int ZERO = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String words = bufferedReader.readLine();
        final StringBuilder stringBuilder = new StringBuilder();

        if (words.contains(LEFT_ARROW) || words.contains(RIGHT_ARROW)) {
            stringBuilder.append(reverseWordsArrow(words)).append(" ");
        } else {
            final StringTokenizer stringTokenizer = new StringTokenizer(words);
            while (stringTokenizer.hasMoreTokens()) {
                stringBuilder.append(reverseWordsNoArrow(stringTokenizer.nextToken())).append(" ");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private static String reverseWordsArrow(final String words) {
        System.out.println("reverseWordsArrow in");
        final char[] wordCharacters = words.toCharArray();
        final Deque<String> reverseWordCharacters = new ArrayDeque<>();
        final Deque<String> tags = new ArrayDeque<>();
        final Deque<String> noTags = new ArrayDeque<>();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wordCharacters.length; i++) {
            String wordCharacter = String.valueOf(wordCharacters[i]);
            if (tags.isEmpty()) { // tag에 화살표가 없을때는 뒤집어야하는 일반 문자 -> 오른쪽 화살표가 나오면 뒤집어서 입력
                if (wordCharacter.equals(LEFT_ARROW)) {
                    System.out.println("LEFTARROW IN");
                    stringBuilder.append(betweenArrowReverseWord(noTags)).append(wordCharacter);
                    tags.push(wordCharacter);
                }else{
                    System.out.println("tags empty and no left arrow");
                    noTags.push(wordCharacter);
                }
            } else {
                if (wordCharacter.equals(RIGHT_ARROW)) {
                    System.out.println("RIGHTARROW IN");
                    stringBuilder.append(wordCharacter);
                    tags.pop();
                }else{
                    System.out.println("tags empty and no right arrow");
                    stringBuilder.append(wordCharacter);
                }
            }
            System.out.println("noTags: "+noTags.toString());
            System.out.println("stringBuilder: "+stringBuilder.toString());
        }



        return stringBuilder.toString();
    }

    private static String betweenArrowReverseWord(final Deque<String> reverseWordCharacters) {
        System.out.println("betweenArrowReverseWord in");
        final StringBuilder stringBuilder = new StringBuilder();
        while (!reverseWordCharacters.isEmpty()) {
            stringBuilder.append(reverseWordCharacters.pop());
        }
        return stringBuilder.toString();
    }

    private static String reverseWordsNoArrow(final String nextToken) {
        final Deque<String> reverseWordCharacters = new ArrayDeque<>();
        final char[] wordCharacters = nextToken.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wordCharacters.length; i++) {
            reverseWordCharacters.push(String.valueOf(wordCharacters[i]));
        }

        while (!reverseWordCharacters.isEmpty()) {
            stringBuilder.append(reverseWordCharacters.pop());
        }

        return stringBuilder.toString();
    }
}
