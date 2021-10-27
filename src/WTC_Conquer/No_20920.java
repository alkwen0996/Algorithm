package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_20920 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final Map<String, Integer> words = new HashMap<>();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        while (N-- > 0) {
            String input = bufferedReader.readLine();

            if (input.length() >= M) {
                if (words.containsKey(input)) {
                    words.put(input, words.get(input) + 1);
                } else {
                    words.put(input, 0);
                }
            }
        }

        String result = solve(words);
        System.out.println(result);
    }

    private static String solve(final Map<String, Integer> words) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<Word> vocabulary = new ArrayList<>();

        for (final String key : words.keySet()) {
            vocabulary.add(new Word(words.get(key), key.length(), key));
        }

        Collections.sort(vocabulary);
        for (Word word : vocabulary) {
            stringBuilder.append(word.letters).append("\n");
        }

        return stringBuilder.toString();
    }

    private static class Word implements Comparable<Word> {
        private int count;
        private int length;
        private String letters;

        public Word(final int count, final int length, final String letters) {
            this.count = count;
            this.length = length;
            this.letters = letters;
        }

        @Override
        public int compareTo(final Word word) {
            if (count > word.count) {
                return -1;
            } else if (count < word.count) {
                return 1;
            } else {
                if (length > word.length) {
                    return -1;
                } else if (length < word.length) {
                    return 1;
                } else {
                    return letters.compareTo(word.letters);
                }
            }

        }
    }

}
