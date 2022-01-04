package Breadth_First_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2468 {
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Coordinate> noSubmerged;
    private static int[] searchWidth = {1, 0, -1, 0};
    private static int[] searchHeight = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        noSubmerged = new LinkedList<>();

        int maxWaterHeight = Integer.MIN_VALUE;
        int minWaterHeight = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                maxWaterHeight = Math.max(maxWaterHeight, map[i][j]);
                minWaterHeight = Math.min(minWaterHeight, map[i][j]);
            }
        }

        int safetyAreaCount = solve(N, maxWaterHeight, minWaterHeight);

        if (maxWaterHeight == minWaterHeight) {
            safetyAreaCount = 1;
        }

        System.out.println(safetyAreaCount);
    }

    private static int solve(final int N, final int maxWaterHeight, final int minWaterHeight) {
        int maxSafetyArea = Integer.MIN_VALUE;

        for (int h = minWaterHeight; h <= maxWaterHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        visited[i][j] = true;
                        count++;
                        noSubmerged.add(new Coordinate(i, j));

                        bfs(h, N);
                    }
                }
            }

            maxSafetyArea = Math.max(maxSafetyArea, count);
        }
        return maxSafetyArea;
    }

    private static void bfs(final int h, final int N) {
        while (!noSubmerged.isEmpty()) {
            Coordinate coordinate = noSubmerged.poll();

            for (int k = 0; k < searchHeight.length; k++) {
                int x = coordinate.x + searchWidth[k];
                int y = coordinate.y + searchHeight[k];

                if (x < N && y < N && x >= 0 && y >= 0) {
                    if (map[x][y] > h && !visited[x][y]) {
                        visited[x][y] = true;
                        noSubmerged.add(new Coordinate(x, y));
                    }
                }

            }
        }

    }

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
