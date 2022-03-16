package BaekJoon.Search;

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
    private static int[] widthSearch = {1, 0, -1, 0};
    private static int[] heightSearch = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        map = new int[n][n];
        noSubmerged = new LinkedList<>();

        int maxWaterHeight = Integer.MIN_VALUE;
        int minWaterHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                maxWaterHeight = Math.max(maxWaterHeight, map[i][j]);
                minWaterHeight = Math.min(minWaterHeight, map[i][j]);
            }
        }

        int safetyAreaCount = solve(maxWaterHeight, minWaterHeight, n);

        if (maxWaterHeight == minWaterHeight) {
            safetyAreaCount = 1;
        }

        System.out.println(safetyAreaCount);
    }

    private static int solve(final int maxWaterHeight, final int minWaterHeight, final int n) {
        int maxSafetyAreaCount = 0;

        for (int h = minWaterHeight; h <= maxWaterHeight; h++) {
            visited = new boolean[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        noSubmerged.add(new Coordinate(i, j));

                        bfs(h, n);
                    }
                }
            }

            maxSafetyAreaCount = Math.max(count, maxSafetyAreaCount);
        }

        return maxSafetyAreaCount;
    }

    private static void bfs(final int h, final int n) {
        while (!noSubmerged.isEmpty()) {
            Coordinate coordinate = noSubmerged.poll();

            for (int k = 0; k < widthSearch.length; k++) {
                int x = coordinate.x + widthSearch[k];
                int y = coordinate.y + heightSearch[k];

                if (x >= 0 && y >= 0 && x < n && y < n) {
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
