package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_14235 {
    public static final int ZERO = 0;
    public static final int NO_PRESENT = -1;
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
        final StringBuilder stringBuilder = new StringBuilder();
        final int numberOfVisits = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfVisits; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int presentValue = Integer.parseInt(stringTokenizer.nextToken());

            if (presentValue == ZERO) {
                if (presents.isEmpty()) {
                    stringBuilder.append(NO_PRESENT).append(NEW_LINE);
                } else {
                    stringBuilder.append(presents.poll()).append(NEW_LINE);
                }
            } else {
                while (stringTokenizer.hasMoreTokens()) {
                    presents.add(Integer.parseInt(stringTokenizer.nextToken()));
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
