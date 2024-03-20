import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());
        final char[][] map = new char[n][m];

        String line;
        for (int i = 0; i < n; i++) {
            line = bufferedReader.readLine();

            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.println(findShortestRoute(map));
    }

    private static int findShortestRoute(final char[][] map) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        final Deque<Wall> queue = new ArrayDeque<>();
        queue.add(new Wall(0, 0, 0, 1));

        final boolean[][][] isVisited = new boolean[map.length][map[0].length][2];
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Wall point = queue.poll();

            if (point.x == map.length - 1 && point.y == map[0].length - 1) {
                return point.route;
            }

            for (int j = 0; j < dx.length; j++) {
                int nextX = point.x + dx[j];
                int nextY = point.y + dy[j];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }

                if (isVisited[nextX][nextY][point.crush]) {
                    continue;
                }

                if (map[nextX][nextY] == '1') { // 벽인 경우
                    if (point.crush == 0) { // 벽을 부신적 없는 경우
                        isVisited[nextX][nextY][1] = true;
                        queue.add(new Wall(nextX, nextY, 1, point.route + 1));
                    }
                }

                if (map[nextX][nextY] == '0') { // 벽이 아닌 경우
                    isVisited[nextX][nextY][point.crush] = true;
                    queue.add(new Wall(nextX, nextY, point.crush, point.route + 1));
                }
            } // for
        } // while

        return -1;
    } // findShortestRoute

    static class Wall {
        private int x;
        private int y;
        private int crush;
        private int route;

        public Wall(final int x, final int y, final int crush, final int route) {
            this.x = x;
            this.y = y;
            this.crush = crush;
            this.route = route;
        }
    }
} // main
