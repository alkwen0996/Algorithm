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
                words.merge(input, 1, Integer::sum);
            }
        }

        String result = solve(words);
        System.out.println(result);
    }

    private static String solve(final Map<String, Integer> words) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Queue<Word> vocabulary = new PriorityQueue<>(Comparator.<Word>comparingInt(w -> -w.frequency)
                .thenComparingInt(Word::compareLength)
                .thenComparing(w -> w.letters));

        for (Map.Entry<String, Integer> word : words.entrySet()) {
            vocabulary.add(new Word(word.getKey(), word.getValue()));
        }

        while (!vocabulary.isEmpty()) {
            stringBuilder.append(vocabulary.poll().letters).append("\n");
        }

        return stringBuilder.toString();
    }

    private static class Word {
        private String letters;
        private int frequency;

        public Word(final String letters, final int frequency) {
            this.letters = letters;
            this.frequency = frequency;
        }

        public int compareLength() {
            return -this.letters.length();
        }
    }

}
