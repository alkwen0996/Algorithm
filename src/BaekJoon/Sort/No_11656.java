package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_11656 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        final Queue<String> words = new PriorityQueue<>();

        for (int i = 0; i < word.length(); i++) {
            words.offer(word.substring(i));
        }

        String result = solve(words);
        System.out.println(result);
    }

    private static String solve(final Queue<String> words) {
        final StringBuilder stringBuilder = new StringBuilder();

        while (!words.isEmpty()) {
            stringBuilder.append(words.poll()).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
