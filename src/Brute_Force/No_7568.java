package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_7568 {
    public static final List<Bulk> peopleBulk = new ArrayList<>();
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            peopleBulk.add(new Bulk(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        String result = solve();
        System.out.println(result);
    }

    private static String solve() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < peopleBulk.size(); i++) {
            stringBuilder.append(checkBulkRank(i)).append(SPACE);
        }

        return stringBuilder.toString();
    }

    private static int checkBulkRank(final int i) {
        int count = 1;

        int tall = peopleBulk.get(i).tall;
        int weight = peopleBulk.get(i).weight;
        for (int j = 0; j < peopleBulk.size(); j++) {
            int compareTall = peopleBulk.get(j).tall;
            int compareWeight = peopleBulk.get(j).weight;
            if (i != j && tall < compareTall && weight < compareWeight) {
                count++;
            }
        }

        return count;
    }

    private static class Bulk {
        private int weight;
        private int tall;

        public Bulk(final int weight, final int tall) {
            this.weight = weight;
            this.tall = tall;
        }
    }
}
