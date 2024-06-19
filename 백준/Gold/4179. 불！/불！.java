import java.awt.*;
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

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int column = Integer.parseInt(stringTokenizer.nextToken());

        char[][] map = new char[row][column];
        Deque<Point> fireBlocks = new ArrayDeque<>();
        Point jihun = null;

        for (int i = 0; i < row; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < column; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'J') {
                    jihun = new Point(i, j);
                }

                if (map[i][j] == 'F') {
                    fireBlocks.add(new Point(i, j));
                }
            }
        }

        int result = escapeMaze(map, jihun, fireBlocks);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private static int escapeMaze(final char[][] map, final Point jihun, final Deque<Point> fireBlocks) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(jihun);
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        isVisited[jihun.x][jihun.y] = true;

        int escapeTime = 0;
        while (!queue.isEmpty()) {
            escapeTime++;
            int size = queue.size();
            fireSpread(map, fireBlocks);

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                for (int j = 0; j < dx.length; j++) {
                    int nextX = current.x + dx[j];
                    int nextY = current.y + dy[j];

                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                        return escapeTime;
                    }

                    if (isVisited[nextX][nextY] || map[nextX][nextY] == '#' || map[nextX][nextY] == 'F') {
                        continue;
                    }

                    map[nextX][nextY] = 'J';
                    queue.add(new Point(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    private static void fireSpread(final char[][] map, final Deque<Point> fireBlocks) {
        int size = fireBlocks.size();

        for (int i = 0; i < size; i++) {
            Point fire = fireBlocks.poll();

            for (int j = 0; j < dx.length; j++) {
                int nextX = fire.x + dx[j];
                int nextY = fire.y + dy[j];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }

                if (map[nextX][nextY] == 'F' || map[nextX][nextY] == '#') {
                    continue;
                }

                map[nextX][nextY] = 'F';
                fireBlocks.add(new Point(nextX, nextY));
            }
        }
    }

} // class
