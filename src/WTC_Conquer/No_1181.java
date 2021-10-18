package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단어 정렬
public class No_1181 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final Set<String> inputWords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            inputWords.add(bufferedReader.readLine());
        }

        final List<String> noDuplicateWords = new ArrayList<>(inputWords);
        solve(noDuplicateWords);
    }

    private static void solve(final List<String> noDuplicateWords) {
        final StringBuilder stringBuilder = new StringBuilder();

        Collections.sort(noDuplicateWords, new Comparator<String>() {
            @Override
            public int compare(final String previousWord, final String nextWord) {
                if (previousWord.length() > nextWord.length()) {
                    return 1;
                } else if (previousWord.length() < nextWord.length()) {
                    return -1;
                } else {
                    return previousWord.compareTo(nextWord);
                }
            }
        });


        for (String noDuplicateWord : noDuplicateWords) {
            stringBuilder.append(noDuplicateWord).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
