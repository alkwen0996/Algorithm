package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1697 {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        if (N >= K) {
            System.out.println(N - K);
        } else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        final Queue<Integer> location = new LinkedList<>();
        location.add(N);

        final int[] visited = new int[100_001];
        visited[N] = 1;

        while (!location.isEmpty()) {
            int currentLocation = location.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = currentLocation - 1;
                } else if (i == 1) {
                    next = currentLocation + 1;
                } else {
                    next = currentLocation * 2;
                }

                if (next == K) {
                    return visited[currentLocation];
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    location.add(next);
                    visited[next] = visited[currentLocation] + 1;
                }
            }

        }

        return 0;
    }
}
