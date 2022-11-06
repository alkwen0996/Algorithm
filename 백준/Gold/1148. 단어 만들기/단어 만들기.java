
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    /*
     * 1. 단어의 길이는 4~10
     * 2. 표의 정중앙 문자는 반듯이 사용해야 한다.
     * 3. 표의 각 문자는 한번만 사용이 가능하다.
     * 4. 글자를 모두 사용하지 않아도 된다.
     * */
    public static final String DICTIONARY_EOF = "-";
    public static final String PUZZLE_EOF = "#";
    public static final int NUMBER_OF_ALPHABET = 26;
    public static final int MAXIMUM_WORDS = 200_000;
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int[][] totalWords = new int[MAXIMUM_WORDS][NUMBER_OF_ALPHABET];

        String input;
        int wordCount = 0;
        while (!(input = bufferedReader.readLine()).equals(DICTIONARY_EOF)) {
            char[] line = input.toCharArray();

            for (int i = 0; i < line.length; i++) {
                totalWords[wordCount][line[i] - 'A']++;
            }

            wordCount++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!(input = bufferedReader.readLine()).equals(PUZZLE_EOF)) {
            final int[] puzzle = new int[NUMBER_OF_ALPHABET];
            char[] line = input.toCharArray();

            for (int i = 0; i < line.length; i++) {
                puzzle[line[i] - 'A']++;
            }

            final int[] result = new int[NUMBER_OF_ALPHABET];
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;

            for (int i = 0; i < wordCount; i++) {
                if (isValid(totalWords[i], puzzle)) {
                    for (int j = 0; j < NUMBER_OF_ALPHABET; j++) {
                        if (totalWords[i][j] != 0) {
                            result[j]++;
                        }
                    }
                }
            }

            for (int j = 0; j < NUMBER_OF_ALPHABET; j++) {
                if (puzzle[j] == 0) {
                    continue;
                }

                if (minimum > result[j]) {
                    minimum = result[j];
                }

                if (maximum < result[j]) {
                    maximum = result[j];
                }
            }

            for (int j = 0; j < NUMBER_OF_ALPHABET; j++) {
                if (puzzle[j] != 0 && result[j] == minimum) {
                    stringBuilder.append((char) ('A' + j));
                }
            }

            stringBuilder.append(SPACE).append(minimum).append(SPACE);

            for (int j = 0; j < NUMBER_OF_ALPHABET; j++) {
                if (puzzle[j] != 0 && result[j] == maximum) {
                    stringBuilder.append((char) ('A' + j));
                }
            }

            stringBuilder.append(SPACE).append(maximum).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static boolean isValid(final int[] totalWords, final int[] puzzle) {
        for (int i = 0; i < totalWords.length; i++) {
            if (totalWords[i] > puzzle[i]) {
                return false;
            }
        }

        return true;
    }

}

