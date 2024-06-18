import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < map.length; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(countYear(map));
    }

    private static int countYear(final int[][] map) {
        int year = 0;
        int count;

        while ((count = countIcebergNumber(map)) < 2) {
            if (count == 0) {
                return 0;
            }

            meltIceberg(map);
            year++;
        }

        return year;
    }

    private static int countIcebergNumber(final int[][] map) {
        final boolean[][] isVisited = new boolean[map.length][map[0].length];
        int icebergMassCount = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                dfs(map, isVisited, i, j);
                icebergMassCount++;
            }
        }

        return icebergMassCount;
    }

    private static void dfs(final int[][] map, final boolean[][] isVisited, final int x, final int y) {
        isVisited[x][y] = true;
        int nextX, nextY;

        for (int i = 0; i < dx.length; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                continue;
            }

            if (isVisited[nextX][nextY] || map[nextX][nextY] == 0) {
                continue;
            }

            dfs(map, isVisited, nextX, nextY);
        }
    }

    private static void meltIceberg(final int[][] map) {
        final boolean[][] isVisited = new boolean[map.length][map[0].length];
        Deque<Iceberg> queue = new ArrayDeque<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    queue.add(new Iceberg(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int waterCount;

            for (int i = 0; i < size; i++) {
                Iceberg iceberg = queue.poll();
                waterCount = 0;

                for (int j = 0; j < dx.length; j++) {
                    int nextX = iceberg.x + dx[j];
                    int nextY = iceberg.y + dy[j];

                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                        continue;
                    }

                    if (isVisited[nextX][nextY] || map[nextX][nextY] != 0) {
                        continue;
                    }

                    waterCount++;
                }

                if (map[iceberg.x][iceberg.y] - waterCount <= 0) {
                    map[iceberg.x][iceberg.y] = 0;
                    continue;
                }

                map[iceberg.x][iceberg.y] -= waterCount;
            }
        }
    }

    static class Iceberg {
        private final int x;
        private final int y;

        public Iceberg(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

} // class
