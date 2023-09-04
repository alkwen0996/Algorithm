import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA < absB) {
                return -1;
            } else if (absA == absB) {
                if (a < b) {
                    return -1;
                } else if (a > b) {
                    return 1;
                }

                return 0;
            }

            return 1;
        });

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == 0) {
                if (queue.isEmpty()) {
                    stringBuilder.append(0).append(NEW_LINE);
                    continue;
                }

                stringBuilder.append(queue.poll()).append(NEW_LINE);
                continue;
            }

            queue.add(number);
        }

        System.out.println(stringBuilder);
    }

}