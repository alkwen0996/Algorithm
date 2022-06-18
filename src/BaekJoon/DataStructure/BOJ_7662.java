package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {

    private static final String NEW_LINE = "\n";
    private static final String INSERT = "I";
    private static final String EMPTY = "EMPTY";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final int inputDataCount = Integer.parseInt(bufferedReader.readLine());
            final TreeMap<Integer, Integer> queue = new TreeMap<>();

            for (int j = 0; j < inputDataCount; j++) {
                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                final String order = stringTokenizer.nextToken();
                final int data = Integer.parseInt(stringTokenizer.nextToken());

                calculate(queue, order, data);
            }

            if(queue.isEmpty()){
                stringBuilder.append(EMPTY).append(NEW_LINE);
                continue;
            }

            stringBuilder.append(queue.lastKey()).append(SPACE).append(queue.firstKey()).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static void calculate(final TreeMap<Integer, Integer> queue, final String order, final int data) {
        if (order.equals(INSERT)) {
            queue.put(data, queue.getOrDefault(data, 0) + 1);
        } else {
            if (queue.isEmpty()) {
                return;
            }

            int key;

            if (data == 1) {
                key = queue.lastKey();
            } else {
                key = queue.firstKey();
            }

            if (queue.put(key, queue.get(key) - 1) == 1) {
                queue.remove(key);
            }
        }

    }

}
