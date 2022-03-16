package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_11866 {
    public static final String LEFT_ARROW = "<";
    public static final String RIGHT_ARROW = ">";
    public static final String COMMA = ",";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int K = Integer.parseInt(stringTokenizer.nextToken());

        String result = solve(N, K);
        System.out.println(result);
    }

    private static String solve(final int n, final int k) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<Integer> josephus = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            josephus.add(i);
        }

        stringBuilder.append(LEFT_ARROW);

        int index = 1;
        while (!josephus.isEmpty()) {
            int number = josephus.poll();
            if (index == k) {
                if (josephus.size() > 0) {
                    stringBuilder.append(number).append(COMMA).append(" ");
                } else {
                    stringBuilder.append(number);
                }

                index = 0;
            } else {
                josephus.add(number);
            }
            index++;
        }

        stringBuilder.append(RIGHT_ARROW);

        return stringBuilder.toString();
    }
}
