import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int MAXIMUM_RANGE = 100_000;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            System.out.println(countTime(n, k));
        }
    }

    private static int countTime(final int n, final int k) {
        final Deque<Subin> queue = new ArrayDeque<>();
        queue.add(new Subin(n, 0));

        final int[] isVisited = new int[MAXIMUM_RANGE + 1];
        Arrays.fill(isVisited, MAXIMUM_RANGE);
        isVisited[n] = 0;

        while (!queue.isEmpty()) {
            final Subin current = queue.poll();

            final int nextA = current.location + 1;
            if (nextA >= 0 && nextA <= MAXIMUM_RANGE && current.time + 1 < isVisited[nextA]) {
                isVisited[nextA] = current.time + 1;
                queue.add(new Subin(nextA, current.time + 1));
            }

            final int nextB = current.location - 1;
            if (nextB >= 0 && nextB <= MAXIMUM_RANGE && current.time + 1 < isVisited[nextB]) {
                isVisited[nextB] = current.time + 1;
                queue.add(new Subin(nextB, current.time + 1));
            }

            final int nextC = current.location * 2;
            if (nextC >= 0 && nextC <= MAXIMUM_RANGE && current.time < isVisited[nextC]) {
                isVisited[nextC] = current.time;
                queue.add(new Subin(nextC, current.time));
            }
        }

        return isVisited[k];
    } // countTime

    static class Subin {
        private int location;
        private int time;

        public Subin(final int location, final int time) {
            this.location = location;
            this.time = time;
        }
    } // Subin

} // main
