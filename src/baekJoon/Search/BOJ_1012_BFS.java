package baekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_BFS {

    private static final String NEW_LINE = "\n";

    private static final int[] width = {1, 0, -1, 0};
    private static final int[] height = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int[][] field;
    private static int connectAreaCount;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int boardWidth = Integer.parseInt(stringTokenizer.nextToken());
            final int boardHeight = Integer.parseInt(stringTokenizer.nextToken());
            final int cabbageCount = Integer.parseInt(stringTokenizer.nextToken());

            field = new int[boardHeight][boardWidth];
            visited = new boolean[boardHeight][boardWidth];
            connectAreaCount = 0;

            for (int j = 0; j < cabbageCount; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                final int x = Integer.parseInt(stringTokenizer.nextToken());
                final int y = Integer.parseInt(stringTokenizer.nextToken());

                field[y][x] = 1;
            }

            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[0].length; k++) {
                    if (field[j][k] == 0) {
                        continue;
                    }

                    if (visited[j][k]) {
                        continue;
                    }

                    bfs(j, k);
                    connectAreaCount++;
                }
            }

            stringBuilder.append(connectAreaCount).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(final int x, final int y) {
        final Queue<Cabbage> queue = new LinkedList<>();
        queue.add(new Cabbage(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            final Cabbage cabbage = queue.poll();

            for (int i = 0; i < width.length; i++) {
                int nextX = cabbage.x + width[i];
                int nextY = cabbage.y + height[i];

                if (nextX >= 0 && nextY >= 0 && nextX < field.length && nextY < field[0].length) {
                    if (visited[nextX][nextY]) {
                        continue;
                    }

                    if (field[nextX][nextY] == 0) {
                        continue;
                    }

                    queue.add(new Cabbage(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

    }

    static class Cabbage {
        private int x;
        private int y;

        public Cabbage(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }

}
